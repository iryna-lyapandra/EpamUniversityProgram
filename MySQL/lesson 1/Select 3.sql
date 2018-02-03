/*1. БД «Комп. фірма». Вкажіть виробника для тих ПК, що мають
жорсткий диск об’ємом не більше 8 Гбайт. Вивести: maker,
type, speed, hd. */
SELECT maker, type, speed, hd
FROM pc, product
WHERE product.model = pc.model AND hd<8;

/*2. БД «Комп. фірма». Знайдіть виробників ПК з процесором не
менше 600 МГц. Вивести: maker.*/
SELECT distinct maker
FROM pc join product
on product.model = pc.model
WHERE speed>=500;

/*3. БД «Комп. фірма». Знайдіть виробників ноутбуків з
процесором не вище 500 МГц. Вивести: maker.*/
SELECT distinct maker
FROM laptop join product
on product.model = laptop.model
WHERE speed<=500;

/*4. БД «Комп. фірма». Знайдіть пари моделей ноутбуків, що
мають однакові об’єми жорстких дисків та RAM (таблиця
Laptop). У результаті кожна пара виводиться лише один раз.
Порядок виведення: модель з більшим номером, модель з
меншим номером, об’єм диску та RAM.*/
SELECT l1.model, l2.model, l1.ram, l1.hd
FROM laptop l1, laptop l2
WHERE l1.ram = l2.ram and l1.hd = l2.hd and l1.model<l2.model
ORDER BY l1.model, l1.hd, l1.ram;

/*5. БД «Кораблі». Знайдіть країни, що мали класи як звичайних
бойових кораблів 'bb', так і класи крейсерів 'bc'. Вивести:
country, типи з класом 'bb', типи з класом 'bc'.*/
SELECT country, type 
FROM classes 
WHERE country IN (select country from classes where `type`='bb') 
AND country IN (select country from classes where `type`='bc');

/*6. БД «Комп. фірма». Знайдіть номер моделі та виробника ПК, яка має ціну менше за 600 дол. Вивести: model, maker. */
SELECT DISTINCT model, maker
FROM pc JOIN product USING (model)
WHERE price < 600;

/* 7. БД «Комп. фірма». Знайдіть номер моделі та виробника прінтера, яка має ціну вищу за 300 дол. Вивести: model, maker. */
SELECT DISTINCT model, maker
FROM printer JOIN product USING (model)
WHERE price > 300;

/* 8. БД «Комп. фірма». Виведіть виробника, номер моделі та ціну кожного комп’ютера, що є у БД. Вивести: maker, model, price. */
SELECT model, maker, price
FROM pc JOIN product USING (model)
UNION
SELECT model, maker, price
FROM laptop JOIN product USING (model);

/* 9. БД «Комп. фірма». Виведіть усі можливі моделі ПК, їх виробників та ціну (якщо вона вказана). Вивести: maker, model, price. */
SELECT model, maker, price
FROM pc JOIN product USING (model);

/* 10. БД «Комп. фірма». Виведіть виробника, тип, модель та частоту процесора для ноутбуків, частота процесорів яких перевищує 600 МГц. Вивести: maker, type, model, speed. */
SELECT maker, model, type, speed
FROM laptop JOIN product USING (model)
WHERE speed > 600;

/* 11. БД «Кораблі». Для кораблів таблиці Ships вивести їх водотоннажність. */
SELECT  name, class, displacement
FROM ships JOIN classes USING (class);

/* 12. БД «Кораблі». Для кораблів, що вціліли у битвах, вивести назви та дати битв, у яких вони брали участь. */
SELECT  outcomes.ship, battles.date
FROM  outcomes JOIN battles ON battles.name = outcomes.battle
WHERE result = "ok";

/*13. БД «Кораблі». Для кораблів таблиці Ships вивести країни, яким вони належать. */
SELECT  name, country
FROM  ships JOIN classes USING (class);

/*14. БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви компаній, яким вони належать*/
SELECT  name
FROM  trip JOIN company USING (ID_comp)
WHERE plane = "boeing";
/*15. БД «Аеропорт». Для пасажирів таблиці Passenger вивести дати, коли вони користувалися послугами авіаліній. */
SELECT  name, date
FROM  passenger JOIN pass_in_trip USING (ID_psg);

