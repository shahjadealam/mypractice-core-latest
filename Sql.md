-> Find nth Highest Salary
SELECT * FROM employee limit 0,5 order by DESC.
-> Joins
- INNER JOIN
  SELECT employee.firstname, employee.lastname, address.city, address.country from employee
  JOIN address ON employee.id = address.id;

- LEFT JOIN
  SELECT employee.firstname, employee.lastname, address.city, address.country from employee
  LEFT JOIN address ON employe.id = address.id;

- RIGHT JOIN
  SELECT employee.firstname, employee.lastname, address.city, address.country from employee
  RIGHT JOIN address ON employe.id = address.id;

- FULL JOIN
  SELECT employee.firstname, employee.lastname, address.city, address.country from employee
  FULL JOIN address ON employe.id = address.id;

- multiple table join
  SELECT employee.firstname, employee.lastname, address.city, address.country, postal.code from employee
  JOIN address ON employe.id = address.id
  JOIN postal ON emplouee.id = postal.id;