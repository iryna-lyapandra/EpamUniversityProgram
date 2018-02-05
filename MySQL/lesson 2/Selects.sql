/*
Написання SQL-запитів SELECT (GROUP BY, HAVING,
статистика, підзапити (ANY, ALL, EXISTS), UNION, CASE ..) */

/*4 (Використ підзапитів у конструкції WHERE з викор. IN, ANY,
ALL)
1. БД «Комп. фірма». Знайдіть виробників, що випускають ПК,
але не ноутбуки (використати операцію IN). Вивести maker.*/

SELECT DISTINCT maker
FROM product
WHERE maker IN 
(SELECT maker FROM product
WHERE type = "PC")
AND maker NOT IN 
(SELECT maker FROM product
WHERE type = "laptop");

/*2. БД «Комп. фірма». Знайдіть виробників, що випускають ПК,
але не ноутбуки (використати ключове слово ALL). Вивести
maker.*/
SELECT DISTINCT maker
FROM product
WHERE type = "PC"
AND  maker != ALL
(SELECT maker
FROM product
WHERE type = "laptop");
/*3. БД «Комп. фірма». Знайдіть виробників, що випускають ПК,
але не ноутбуки (використати ключове слово ANY). Вивести
maker.*/
SELECT DISTINCT maker
FROM product
WHERE maker = ANY
(SELECT maker
FROM product
WHERE type = "PC")
AND NOT maker = ANY 
(SELECT maker
FROM product
WHERE type = "laptop");
/*4. БД «Комп. фірма». Знайдіть виробників, що випускають
одночасно ПК та ноутбуки (використати операцію IN).
Вивести maker.*/
SELECT DISTINCT maker
FROM product
WHERE maker IN
(SELECT maker
FROM product
WHERE type = "PC")
AND maker IN 
(SELECT maker
FROM product
WHERE type = "laptop");
/*5. БД «Комп. фірма». Знайдіть виробників, що випускають
одночасно ПК та ноутбуки (використати ключове слово ALL).
Вивести maker.*/
SELECT DISTINCT maker
FROM product
WHERE NOT maker != ALL
(SELECT maker
FROM product
WHERE type = "PC")
AND NOT maker != ALL
(SELECT maker
FROM product
WHERE type = "laptop");

/*5 (Використання підзапитів з лог. операцією EXISTS)
1. БД «Комп. фірма». Знайти тих виробників ПК, усі моделі ПК
яких є у наявності в таблиці PC (використовуючи операцію
EXISTS). Вивести maker.*/
SELECT DISTINCT maker 
FROM product p 
WHERE EXISTS (SELECT * FROM pc WHERE p.model = model);
/*2. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК зі
швидкістю 750 МГц та вище. Виведіть: maker.*/
SELECT maker
FROM product as P 
WHERE EXISTS (SELECT model FROM PC WHERE speed >= 750 AND model = P.model)

/* 3. БД «Комп. фірма». Знайдіть виробників, які б випускали
одночасно ПК та ноутбуки зі швидкістю 750 МГц та вище.
Виведіть: maker.*/
SELECT distinct maker
FROM product
WHERE maker IN (SELECT maker
FROM product as P 
WHERE EXISTS (SELECT model FROM PC WHERE speed >= 750 AND model = P.model))
AND
MAKER IN  (SELECT maker
FROM product as P 
WHERE EXISTS (SELECT model FROM laptop WHERE speed >= 750 AND model = P.model))
/* 4. БД «Комп. фірма». Знайдіть виробників принтерів, що
випускають ПК з найвищою швидкістю процесора. Виведіть:
maker.*/
SELECT maker
FROM product p
WHERE EXISTS 
(SELECT model FROM pc 
WHERE model = p.model AND speed IN (SELECT MAX(speed) FROM pc))
/* 5. За Вашингтонським міжнародним договором від початку 1922
р. заборонялося будувати лінійні кораблі водотоннажністю
понад 35 тис. тонн. Вкажіть кораблі, що порушили цей договір
(враховувати лише кораблі з відомим спуском на воду, тобто з
таблиці Ships). Виведіть: name, launched, displacement.*/
SELECT name, launched, displacement
FROM ships JOIN classes USING (class)
WHERE displacement >35000
AND launched >= 1922;
/* 6 (Конкатенація стрічок чи мат. обчислення чи робота з датами)
1. БД «Комп. фірма». Виведіть середню ціну ноутбуків з
попереднім текстом 'середня ціна = '.*/
SELECT AVG(price) as `середня ціна`
FROM laptop;
/* 2. БД «Комп. фірма». Для таблиці PC вивести усю інформацію з
коментарями у кожній комірці, наприклад, 'модель: 1121',
'ціна: 600,00' і т.д. */
SELECT 
CONCAT("code: ", code) code,
CONCAT("model: ", model) model,
CONCAT("speed: ", speed) speed,
CONCAT("ram: ", ram) ram,
CONCAT("hd: ", hd) hd,
CONCAT("cd: ", cd) cd,
CONCAT("price: ", price) price
FROM pc;
/* 3. БД «Фірма прий. вторсировини». З таблиці Income виведіть
дати у такому форматі: рік.число_місяця.день, наприклад,
2001.02.15 (без формату часу). */
SELECT CONCAT(YEAR(date), ".", MONTH(date), ".", DAY(date)) as new_date
FROM income;
/* 4. БД «Кораблі». Для таблиці Outcomes виведіть дані, а заміcть
значень стовпця result, виведіть еквівалентні їм надписи
українською мовою. */
SELECT ship, battle, CASE result
WHEN 'sunk' THEN 'потоплений'
WHEN 'damaged' THEN 'пошкоджений'
WHEN 'OK' THEN 'неушкоджений'
END AS result 
FROM outcomes;
/* 5. БД «Аеропорт». Для таблиці Pass_in_trip значення стовпця
place розбити на два стовпця з коментарями, наприклад,
перший – 'ряд: 2' та другий – 'місце: a'. */
SELECT CONCAT('ряд: ', LEFT(place, 1)) AS ряд, 
CONCAT('місце: ', RIGHT(place, 1)) AS місце 
FROM pass_in_trip;
/* 7 (Статистичні функції та робота з групами) 
1. БД «Комп. фірма». Знайдіть принтери, що мають найвищу
ціну. Вивести: model, price. */
SELECT model 
FROM printer
WHERE price = ANY (SELECT MAX(price) FROM printer)
/* 2. БД «Комп. фірма». Знайдіть ноутбуки, швидкість яких є
меншою за швидкість будь-якого з ПК. Вивести: type, model,
speed. */
SELECT model 
FROM laptop
WHERE speed < ANY (SELECT MIN(speed) FROM pc)
/* 3. БД «Комп. фірма». Знайдіть виробників найдешевших
кольорових принтерів. Вивести: maker, price.*/
SELECT maker
FROM product
WHERE model IN (SELECT model FROM printer WHERE color = "y" AND price IN
															(SELECT MIN(price) FROM printer WHERE color = "y"))
/* 4. БД «Комп. фірма». Знайдіть виробників, що випускають по
крайній мірі дві різні моделі ПК. Вивести: maker, число
моделей. (Підказка: використовувати підзапити у якості
обчислювальних стовпців та операцію групування)*/
SELECT COUNT(DISTINCT model) as count_model, maker 
FROM PRODUCT 
WHERE type = "pc"
GROUP BY maker 
HAVING count_model >= 2/**/

/* 5. БД «Комп. фірма». Знайдіть середній розмір жорсткого диску
ПК (одне значення на всіх) тих виробників, які також
випускають і принтери. Вивести: середній розмір жорсткого
диску.*/
SELECT avg(hd)
FROM product JOIN pc USING (model)
WHERE maker IN (SELECT maker
FROM product WHERE 
maker IN (SELECT maker
FROM product WHERE type = "pc")
AND maker IN (SELECT maker
FROM product WHERE type = "laptop"))
/* 8 (Підзапити у якості обчислювальних стовпців)
1. БД «Комп. фірма». Для таблиці Product отримати підсумковий
набір у вигляді таблиці зі стовпцями maker, pc, laptop та printer,
в якій для кожного виробника необхідно вказати кількість
продукції, що ним випускається, тобто наявну загальну
кількість продукції у таблицях, відповідно, PC, Laptop та
Printer. (Підказка: використовувати підзапити у якості
обчислювальних стовпців)*/

/* 2. БД «Комп. фірма». Для кожного виробника знайдіть середній
розмір екрану для ноутбуків, що ним випускається. Вивести:
maker, середній розмір екрану. (Підказка: використовувати
підзапити у якості обчислювальних стовпців)*/
SELECT maker, AVG(screen)
FROM product JOIN laptop USING (model)
GROUP BY maker;
/* 3. БД «Комп. фірма». Знайдіть максимальну ціну ПК, що
випускаються кожним виробником. Вивести: maker,
максимальна ціна. (Підказка: використовувати підзапити у
якості обчислювальних стовпців)*/
SELECT maker, MAX(price)
FROM product JOIN pc USING (model)
GROUP BY maker;
/* БД «Комп. фірма». Знайдіть мінімальну ціну ПК, що
випускаються кожним виробником. Вивести: maker,
максимальна ціна. (Підказка: використовувати підзапити у
якості обчислювальних стовпців)*/
SELECT maker, MIN(price)
FROM product JOIN pc USING (model)
GROUP BY maker;

/* 5. БД «Комп. фірма». Для кожного значення швидкості ПК, що
перевищує 600 МГц, визначіть середню ціну ПК з такою ж
швидкістю. Вивести: speed, середня ціна. (Підказка:
використовувати підзапити у якості обчислювальних
стовпців)*/
/* SELECT pc1.speed, AVG(price_same_speed) 
FROM pc AS pc1, (SELECT price FROM pc WHERE speed = pc1.speed) AS price_same_speed
GROUP BY speed
HAVING speed > 600;
*/
/*9 (Оператор CASE)
1. БД «Комп. фірма». Для таблиці Product отримати підсумковий
набір у вигляді таблиці зі стовпцями maker, pc, в якій для
кожного виробника необхідно вказати, чи виробляє він ('yes'),
чи ні ('no') відповідний тип продукції. У першому випадку
('yes') додатково вказати поруч у круглих дужках загальну
кількість наявної (тобто, що знаходиться у таблиці PC)
продукції, наприклад, 'yes(2)'. (Підказка: використовувати
підзапити у якості обчислювальних стовпців та оператор
CASE)*/



