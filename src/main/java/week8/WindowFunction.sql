--Assign row numbers based on salary
SELECT
    name,
    salary,
    ROW_NUMBER() OVER(ORDER BY salary DESC) AS row_num
FROM employees

--Rank employees by salary
SELECT
    name,
    salary,
    RANK() OVER(ORDER BY salary DESC) AS salary_rank
FROM employees;

--Use dense ranking
SELECT
    name,
    salary,
    DENSE_RANK() OVER(ORDER BY salary DESC) AS salary_rank
FROM employees;

--Rank employees within their departments
SELECT
    name,
    department,
    salary,
    DENSE_RANK() OVER(
        PARTITION BY department
        ORDER BY salary DESC
    ) AS department_rank
FROM employees;

--Find the average salary within each department
SELECT
    name,
    department,
    salary,
    AVG(salary) OVER(
        PARTITION BY department
    ) AS department_average
FROM employees;

--Find the highest-paid employee in each department.
SELECT * FROM(
select name,department,salary, DENSE_RANK() OVER(PARTITION BY department ORDER BY salary DESC) as salary_rank
FROM employees) ranked where salary_rank=1;

--Find the top 2 highest-paid employees in each department.
SELECT *
FROM (
    SELECT
        name,
        department,
        salary,
        DENSE_RANK() OVER(
            PARTITION BY department
            ORDER BY salary DESC
        ) AS salary_rank
    FROM employees
) ranked
WHERE salary_rank <= 2;

--Show every employee along with the average salary of their department.
SELECT
    name,
    department,
    salary,
    AVG(salary) OVER(
        PARTITION BY department
    ) AS department_average
FROM employees;

--Find the second-highest distinct salary.
SELECT salary
FROM (
    SELECT
        salary,
        DENSE_RANK() OVER(
            ORDER BY salary DESC
        ) AS salary_rank
    FROM employees
) ranked
WHERE salary_rank = 2;