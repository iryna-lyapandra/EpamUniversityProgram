USE storedpr_db;
-- 1.Забезпечити цілісність значень для структури БД.

DROP TRIGGER before_insert_employee IF EXISTS
DELIMITER // 
CREATE TRIGGER before_insert_employee
BEFORE INSERT
ON employee FOR EACH ROW
BEGIN
IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - pharmacy isn't in the list";
END IF;
IF NOT EXISTS (SELECT * FROM post p WHERE p.post = NEW.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - post isn't in the list";
END IF;
END //
DELIMITER ;

DROP TRIGGER before_update_employee IF EXISTS
DELIMITER // 
CREATE TRIGGER before_update_employee
BEFORE UPDATE
ON employee FOR EACH ROW
BEGIN
IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - pharmacy isn't in the list";
END IF;
IF NOT EXISTS (SELECT * FROM post p WHERE p.post = NEW.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - post isn't in the list";
END IF;
END //
DELIMITER ;

DROP TRIGGER before_delete_post IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_post
BEFORE DELETE
ON post FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee e WHERE e.post = OLD.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - post is being used in the employee table";
 END IF;
END //
DELIMITER ;


DROP TRIGGER before_insert_pharmacy IF EXISTS
DELIMITER // 
CREATE TRIGGER before_insert_pharmacy
BEFORE INSERT
ON pharmacy FOR EACH ROW
BEGIN
IF NOT EXISTS (SELECT * FROM street s WHERE s.street = NEW.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - street isn't in the list";
END IF;
DELIMITER ;

DROP TRIGGER before_update_pharmacy IF EXISTS
DELIMITER // 
CREATE TRIGGER before_update_pharmacy
BEFORE INSERT
ON pharmacy FOR EACH ROW
BEGIN
IF NOT EXISTS (SELECT * FROM street s WHERE s.street = NEW.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - street isn't in the list";
END IF;
DELIMITER ;

DROP TRIGGER before_delete_pharmacy IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_pharmacy
BEFORE DELETE
ON pharmacy FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee e WHERE e.pharmacy_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - pharmacy is being used in the employee table";
 END IF;
 IF EXISTS (SELECT * FROM pharmacy_medicine pm WHERE pm.pharmacy_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - pharmacy is being used in the pharmacy_medicine table";
 END IF;
END //
DELIMITER ;

DROP TRIGGER before_delete_street IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_street
BEFORE DELETE
ON post FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM pharmacy p WHERE p.street = OLD.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - post is being used in the employee table";
 END IF;
END //
DELIMITER ;

DROP TRIGGER  before_insert_pharmacy_medicine IF EXISTS
DELIMITER //
CREATE TRIGGER before_insert_pharmacy_medicine
BEFORE INSERT
ON pharmacy_medicine FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - pharmacy isn't in the list";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - medicine isn't in the list";
 END IF;
END //
DELIMITER ;

DROP TRIGGER  before_update_pharmacy_medicine IF EXISTS
DELIMITER //
CREATE TRIGGER before_update_pharmacy_medicine
BEFORE UPDATE
ON pharmacy_medicine FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - pharmacy isn't in the list";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - medicine isn't in the list";
 END IF;
END //
DELIMITER ;

DROP TRIGGER before_delete_medicine IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_medicine
BEFORE DELETE
ON medicine FOR EACH ROW
BEGIN 
IF EXISTS (SELECT * FROM pharmacy_medicine pm WHERE pm.medicine_id = OLD.id)
    THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - medicine is being used in the pharmacy_medicine table";
END IF;
IF EXISTS (SELECT * FROM medicine_zone mz WHERE mz.medicine_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - medicine is being used in the pharmacy_medicine table";
END IF;
END //
DELIMITER ;

DROP TRIGGER before_insert_medicine_zone IF EXISTS
DELIMITER //
CREATE TRIGGER before_insert_medicine_zone
BEFORE INSERT
ON medicine_zone FOR EACH ROW
BEGIN 
IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - medicine_id isn't in the list";
END IF;
IF NOT EXISTS (SELECT * FROM zone z WHERE z.id = NEW.zone_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - zone_id isn't in the list";
END IF;
END //
DELIMITER ;

DROP TRIGGER before_delete_zone IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_zone
BEFORE DELETE
ON pharmacy FOR EACH ROW
BEGIN
IF EXISTS (SELECT * FROM medicine_zone mz WHERE mz.medicine_id = OLD.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform delete - medicine is being used in the pharmacy_medicine";
END IF;
END //
DELIMITER ;

-- 2. Співробітники→ Ідентифікаційний номер не може закінчувати двома нулями;
DROP TRIGGER check_identity_number_insert IF EXISTS
DELIMITER //
CREATE TRIGGER check_identity_number_insert
BEFORE INSERT
ON empoyee FOR EACH ROW
BEGIN
  IF (NEW.identity_number RLIKE '%00')
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - identity number can't end with 00";
 END IF;
END //
DELIMITER ;

DROP TRIGGER check_identity_number_update IF EXISTS
DELIMITER //
CREATE TRIGGER check_identity_number_update
BEFORE INSERT
ON empoyee FOR EACH ROW
BEGIN
  IF (NEW.identity_number RLIKE '%00')
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - identity number can't end with 00";
 END IF;
END //
DELIMITER ;

-- 3. для Перелік лікарств→ Код міністерства забезпечити формат вводу:
2 довільні букви, окрім М і П + '-' + 3 цифри + '-' + 2цифри.

DROP TRIGGER check_ministry_code_insert IF EXISTS
DELIMITER //
CREATE TRIGGER check_ministry_code_insert
BEFORE INSERT
ON medicine FOR EACH ROW
BEGIN
  IF (NEW.ministry_code RLIKE '^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$')
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform insert - wrong format of ministry code";
 END IF;
END //
DELIMITER ;

DROP TRIGGER check_ministry_code_update IF EXISTS
DELIMITER //
CREATE TRIGGER check_ministry_code_insert
BEFORE INSERT
ON medicine FOR EACH ROW
BEGIN
  IF (NEW.ministry_code RLIKE '^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$')
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Can't perform update - wrong format of ministry code";
 END IF;
END //
DELIMITER ;

-- 4. Заборонити будь-яку модифікацію даних в таблиці Посада.
DROP TRIGGER before_insert_post IF EXISTS
DELIMITER //
CREATE TRIGGER before_insert_post
  BEFORE INSERT
  ON post FOR EACH ROW
  BEGIN
      SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'post table cannot be modified';
  END //
DELIMITER ;

DROP TRIGGER before_update_post IF EXISTS
DELIMITER //
CREATE TRIGGER before_update_post
  BEFORE UPDATE
  ON post FOR EACH ROW
  BEGIN
      SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'post table cannot be modified';
  END //
DELIMITER ;

DROP TRIGGER before_delete_post IF EXISTS
DELIMITER //
CREATE TRIGGER before_delete_post
  BEFORE DELETE
  ON post FOR EACH ROW
  BEGIN
      SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'post table cannot be modified';
  END //
DELIMITER ;

