1.	SELECT maker, type FROM labor_sql.product WHERE type='laptop' ORDER BY maker;
2.	SELECT model, ram, screen, price FROM labor_sql.laptop WHERE price>1000 ORDER BY ram, price DESC;
3.	SELECT * FROM labor_sql.printer WHERE color = "y";
4.	SELECT model, speed, hd, cd, price FROM labor_sql.pc WHERE (cd = "12x" OR cd = "24x") AND price < 600 ORDER BY speed DESC;
5.	SELECT name, class FROM labor_sql.ships WHERE name = class ORDER BY name;
6.	SELECT * FROM labor_sql.pc WHERE speed >= 500 AND price < 800 ORDER BY price DESC;
7.	SELECT * FROM labor_sql.printer WHERE NOT type =  "Matrix" AND price < 300 ORDER BY type DESC;
8.	SELECT model, speed FROM labor_sql.pc WHERE price BETWEEN 400 AND 600 ORDER BY hd;
9.	SELECT model, speed, hd FROM labor_sql.pc WHERE hd IN(10, 20) AND model IN (SELECT model FROM labor_sql.product WHERE maker = 'A')
UNION ALL
SELECT model, speed, hd FROM labor_sql.laptop WHERE hd IN(10, 20) AND model IN (SELECT model FROM labor_sql.product WHERE maker = 'A') ORDER BY speed;
10.	SELECT model, speed, hd, price FROM labor_sql.laptop WHERE screen >=12 ORDER BY price DESC;
11.	SELECT model, type, price FROM labor_sql.printer WHERE price < 300 ORDER BY price DESC;
12.	SELECT model, ram, price FROM labor_sql.laptop WHERE ram = 64 ORDER BY screen;
13.	SELECT model, ram, price FROM labor_sql.pc WHERE ram > 64 ORDER BY hd;
14.	SELECT model, speed, price FROM labor_sql.pc WHERE speed BETWEEN 500 AND 750 ORDER BY hd;
15.	SELECT * FROM labor_sql.outcome_o WHERE `out` > 2000 ORDER BY `date` DESC;
16.	SELECT * FROM labor_sql.income_o WHERE `inc` BETWEEN 5000 AND 10000 ORDER BY `inc` DESC;
17.	SELECT * FROM labor_sql.income WHERE point = 1 ORDER BY inc;
18.	SELECT * FROM labor_sql.outcome WHERE point = 2 ORDER BY `out`;
19.	SELECT * FROM labor_sql.classes WHERE country = "Japan" ORDER BY `type` DESC; 
20.	SELECT `name`, launched FROM labor_sql.ships WHERE launched BETWEEN 1920 AND 1942 ORDER BY launched DESC;
21.	SELECT * FROM labor_sql.outcomes WHERE battle = "Guadalcanal" AND result != "sunk" ORDER BY ship DESC; 
22.	SELECT * FROM labor_sql.outcomes WHERE result = "sunk" ORDER BY ship DESC;
23.	SELECT class, displacement FROM labor_sql.classes WHERE displacement >= 40000 ORDER BY `type`; 
24.	SELECT trip_no, town_from, town_to FROM labor_sql.trip WHERE town_from = "London" OR town_to = "London" ORDER BY time_out;
25.	SELECT trip_no, plane, town_from, town_to FROM labor_sql.trip WHERE plane = "TU-134" ORDER BY time_out DESC;
26.	SELECT trip_no, plane, town_from, town_to FROM labor_sql.trip WHERE plane != "IL-86" ORDER BY plane;
27.	SELECT trip_no, town_from, town_to FROM labor_sql.trip WHERE town_from != "Rostov" AND town_to != "Rostov" ORDER BY plane;
28.	
