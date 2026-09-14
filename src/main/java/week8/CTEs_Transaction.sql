--Create a CTE containing employees earning more than ₹70,000.
WITH high_salary as(
    select * from employees where salary>70000
)

select * from high_salary;

--Find departments where the average salary is greater than ₹65,000.
WITH avg_salary as(
    select department, avg(salary) as avgSalary
    from employees
    group by (department)
)
select * from avg_salary where avgSalary>65000;

--Using a CTE + DENSE_RANK(), find the highest-paid employee in each department.
WITH highest_paid as(
select
    name,
    department,
    salary,
    DENSE_RENK()
    OVER(PARTITION BY department ORDER BY salary DESC) AS salary_rank
    from employees
)
select * from highest_paid whers salary_rank=1;

--Using a CTE, find the second-highest distinct salary.
WITH ranked_salaries AS (
    select
        salary,
        DENSE_RANK() OVER (
            ORDER BY salary DESC
        ) AS salary_rank
    FROM employees
)
select distinct salary
from ranked_salaries
where salary_rank = 2;

-- Challenge 5
--Create two CTEs:
--
--CTE 1 → Employees earning > 60K
--CTE 2 → IT employees from CTE 1

WITH high_salary AS (
    select *
    from employees
    where salary > 60000
),
it_employees AS (
    select *
    from high_salary
    where department = 'IT'
)
select *
from it_employees;

-- Transaction
START TRANSACTION;

UPDATE accounts
SET balance = balance - 1000
WHERE account_id = 1;

UPDATE accounts
SET balance = balance + 1000
WHERE account_id = 2;

COMMIT;

--rollback
START TRANSACTION;

UPDATE accounts
SET balance = balance - 1000
WHERE account_id = 1;

ROLLBACK;

--SAVEPOINT
START TRANSACTION;

UPDATE accounts
SET balance = balance - 10000
WHERE account_id = 1;

SAVEPOINT after_debit;

UPDATE accounts
SET balance = balance + 10000
WHERE account_id = 2;

ROLLBACK TO after_debit;

COMMIT;