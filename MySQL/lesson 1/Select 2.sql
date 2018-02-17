1.	SELECT model FROM labor_sql.pc WHERE model LIKE "%1%1%";
2.	SELECT * FROM labor_sql.outcome WHERE MONTH(date) = 3;
3.	SELECT * FROM labor_sql.outcome_o WHERE DAY(date) = 14;
4.	SELECT `name` FROM labor_sql.ships WHERE `name` LIKE "W%n";
5.	---
6.	SELECT `name`, launched FROM labor_sql.ships WHERE `name` NOT LIKE "%a";
7.	SELECT * FROM labor_sql.ships WHERE name LIKE "% %" AND name NOT LIKE "%c";
8.	SELECT * FROM labor_sql.trip WHERE HOUR(time_out) BETWEEN 12 AND 16;
9.	SELECT * FROM labor_sql.trip WHERE HOUR(time_out) BETWEEN 17 AND 22;
10.	SELECT date FROM labor_sql.pass_in_trip WHERE place LIKE "1%";
11.	SELECT date FROM labor_sql.pass_in_trip WHERE place LIKE "%c";
12.	SELECT substring_index(`name`, " ", -1) AS last_name FROM labor_sql.passenger WHERE substring_index(`name`, " ", -1) LIKE "C%";
13.	SELECT substring_index(`name`, " ", -1) AS last_name FROM labor_sql.passenger WHERE substring_index(`name`, " ", -1)  NOT LIKE "J%";
