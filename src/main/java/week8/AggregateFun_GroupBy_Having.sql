--count all employees
SELECT COUNT(*) FROM employees;

--Find total salary
SELECT SUM(salary) FROM employees;

--Find average salary
SELECT ROUND(AVG(salary),2) FROM employees;

--Find highest and lowest salary
SELECT
 MAX(salary) as max_salary,
 MIN(salary) as min_salary
FROM employees;

--Number of employees in each department
SELECT department,COUNT(*)
FROM employees
GROUP BY(department);

--Average salary in each department
SELECT department, AVG(salary)
FROM employees
GROUP BY(department);

--Total salary in each department
SELECT department, SUM(salary)
FROM employees
GROUP BY(department);

--Highest salary in each department
SELECT department, MAX(salary)
FROM employees
GROUP BY(department);

--Find departments with more than one employee.
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY (department)
HAVING count(*)>1;

--Find departments where the average salary is greater than ₹65,000.
SELECT department, AVG(salary) as AVG_PAY
FROM employees
GROUP BY(department)
HAVING AVG_PAY>65000;

--Find the total salary for each city.
SELECT city, SUM(salary) as TOTAL_SALARY
FROM employees
GROUP BY(city)

--Find cities having at least two employees.
SELECT city, COUNT(*) as employeeCount
FROM employees
GROUP BY(city)
HAVING employeeCount>=2

--Find the number of employees in each department, excluding employees earning less than ₹60,000.
SELECT department, COUNT(*) as employeeCount
FROM employees
WHERE salary>=60000
GROUP BY(department);