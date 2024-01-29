CREATE DATABASE training;

USE training;

CREATE TABLE employee (	
	id int,
	name text,
	age int,
	designation text,
	department text,
	country text,
	PRIMARY KEY(id)
);

SELECT * FROM employee;

INSERT INTO employee (id, name, age, designation, department, country) VALUES (100, 'Anand', 25, 'Developer', 'IT', 'India');
UPDATE employee SET designation = 'IT' WHERE id = 100;
DELETE FROM employee WHERE id = 100;
TRUNCATE employee;
DROP TABLE employee;
DROP DATABASE training;