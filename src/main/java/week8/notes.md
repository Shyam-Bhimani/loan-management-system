# SQL Cheat Sheet

## 1. Basic SQL Query

### Query Order

```sql
SELECT → Choose columns
FROM → Choose table
WHERE → Filter rows
GROUP BY → Group rows
HAVING → Filter groups
ORDER BY → Sort results
LIMIT → Restrict number of rows
```

### Basic Syntax

```sql
SELECT column1, column2
FROM table_name
WHERE condition
ORDER BY column1 ASC
LIMIT 10;
```

### Example

```sql
SELECT name, salary
FROM employees
WHERE salary >= 60000
ORDER BY salary DESC
LIMIT 10;
```

---

# 2. SELECT

### Select specific columns

```sql
SELECT name, salary
FROM employees;
```

### Select all columns

```sql
SELECT *
FROM employees;
```

### DISTINCT

Remove duplicate values.

```sql
SELECT DISTINCT department
FROM employees;
```

### Alias

```sql
SELECT
    name AS employee_name,
    salary AS monthly_salary
FROM employees;
```

---

# 3. WHERE — Filter Rows

### Comparison Operators

```sql
=       Equal
<>      Not equal
!=      Not equal
>       Greater than
<       Less than
>=      Greater than or equal
<=      Less than or equal
```

### Logical Operators

```sql
AND
OR
NOT
```

Example:

```sql
SELECT *
FROM employees
WHERE salary >= 60000
  AND department = 'IT';
```

---

# 4. BETWEEN

```sql
SELECT *
FROM employees
WHERE salary BETWEEN 50000 AND 80000;
```

`BETWEEN` is inclusive.

---

# 5. IN

Instead of multiple `OR` conditions:

```sql
SELECT *
FROM employees
WHERE department IN ('IT', 'HR', 'Finance');
```

---

# 6. LIKE

Used for pattern matching.

```sql
-- Starts with A
WHERE name LIKE 'A%'

-- Ends with A
WHERE name LIKE '%A'

-- Contains A
WHERE name LIKE '%A%'

-- Exactly one character before A
WHERE name LIKE '_A%'
```

### Wildcards

```text
% → Any number of characters
_ → Exactly one character
```

---

# 7. NULL

### Check NULL

```sql
SELECT *
FROM employees
WHERE manager_id IS NULL;
```

### Check NOT NULL

```sql
SELECT *
FROM employees
WHERE manager_id IS NOT NULL;
```

❌ Don't use:

```sql
WHERE manager_id = NULL;
```

---

# 8. ORDER BY — Sorting

### Ascending

```sql
SELECT *
FROM employees
ORDER BY salary ASC;
```

### Descending

```sql
SELECT *
FROM employees
ORDER BY salary DESC;
```

### Multiple columns

```sql
SELECT *
FROM employees
ORDER BY department ASC, salary DESC;
```

---

# 9. LIMIT

Restrict the number of returned rows.

```sql
SELECT *
FROM employees
ORDER BY salary DESC
LIMIT 5;
```

> `LIMIT` syntax varies by database. SQL Server commonly uses `TOP` or `OFFSET ... FETCH`.

---

# 10. JOIN Cheat Sheet

| JOIN              | Returns                                                   |
| ----------------- | --------------------------------------------------------- |
| `INNER JOIN`      | Only matching records from both tables                    |
| `LEFT JOIN`       | All records from left table + matching records from right |
| `RIGHT JOIN`      | All records from right table + matching records from left |
| `FULL OUTER JOIN` | All records from both tables                              |
| `CROSS JOIN`      | Every possible combination of rows                        |
| `SELF JOIN`       | A table joined with itself                                |

### INNER JOIN

```sql
SELECT e.name, d.department_name
FROM employees e
INNER JOIN departments d
    ON e.department_id = d.department_id;
```

### LEFT JOIN

```sql
SELECT e.name, d.department_name
FROM employees e
LEFT JOIN departments d
    ON e.department_id = d.department_id;
```

### Important

```text
INNER JOIN → Matching only
LEFT JOIN  → Everything from LEFT + matches
RIGHT JOIN → Everything from RIGHT + matches
FULL JOIN  → Everything from BOTH
```

---

# 11. Aggregate Functions

Used to calculate values across multiple rows.

```sql
COUNT(*)
SUM(column)
AVG(column)
MIN(column)
MAX(column)
```

### Examples

```sql
SELECT COUNT(*)
FROM employees;
```

```sql
SELECT SUM(salary)
FROM employees;
```

```sql
SELECT AVG(salary)
FROM employees;
```

```sql
SELECT MIN(salary), MAX(salary)
FROM employees;
```

---

# 12. GROUP BY

Used to group rows before applying aggregate functions.

### Basic Pattern

```sql
SELECT column, AGGREGATE(column)
FROM table
GROUP BY column;
```

### Example

```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY department;
```

### Multiple columns

```sql
SELECT department, job_title, COUNT(*) AS employee_count
FROM employees
GROUP BY department, job_title;
```

---

# 13. HAVING — Filter Groups

`WHERE` filters **rows**.

`HAVING` filters **groups**.

### Syntax

```sql
SELECT column, COUNT(*)
FROM table
GROUP BY column
HAVING COUNT(*) >= 2;
```

### Example

```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY department
HAVING COUNT(*) >= 2;
```

---

# 14. WHERE vs HAVING

| WHERE                                        | HAVING                            |
| -------------------------------------------- | --------------------------------- |
| Filters rows                                 | Filters groups                    |
| Used before `GROUP BY`                       | Used after `GROUP BY`             |
| Usually cannot use aggregate result directly | Designed for aggregate conditions |

### Example

```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
WHERE salary >= 60000
GROUP BY department
HAVING COUNT(*) >= 2
ORDER BY employee_count DESC;
```

### Remember

```text
WHERE  → Filter rows
GROUP BY → Create groups
HAVING → Filter groups
```

---

# 15. CASE Statement

Used for conditional logic.

### Syntax

```sql
CASE
    WHEN condition THEN result
    WHEN condition THEN result
    ELSE result
END
```

### Example

```sql
SELECT
    name,
    salary,
    CASE
        WHEN salary >= 100000 THEN 'High'
        WHEN salary >= 60000 THEN 'Medium'
        ELSE 'Low'
    END AS salary_category
FROM employees;
```

---

# 16. COALESCE

Returns the first non-NULL value.

```sql
SELECT
    name,
    COALESCE(phone, 'Not Available') AS phone
FROM employees;
```

Useful for handling `NULL` values.

---

# 17. String Functions

Common functions:

```sql
UPPER(column)
LOWER(column)
LENGTH(column)
CONCAT(column1, column2)
TRIM(column)
```

Example:

```sql
SELECT UPPER(name)
FROM employees;
```

---

# 18. Date Functions

Common operations:

```sql
CURRENT_DATE
CURRENT_TIMESTAMP
```

Example:

```sql
SELECT *
FROM employees
WHERE joining_date >= '2026-01-01';
```

> Date functions differ between MySQL, PostgreSQL, Oracle, and SQL Server.

---

# 19. Window Functions

Window functions perform calculations across related rows **without collapsing rows**.

## Basic Window Function

```sql
AVG(salary) OVER()
```

Example:

```sql
SELECT
    name,
    salary,
    AVG(salary) OVER() AS company_avg_salary
FROM employees;
```

---

## PARTITION BY

Calculate separately for each group.

```sql
AVG(salary) OVER(
    PARTITION BY department
)
```

Example:

```sql
SELECT
    name,
    department,
    salary,
    AVG(salary) OVER(
        PARTITION BY department
    ) AS department_avg_salary
FROM employees;
```

---

# 20. ROW_NUMBER

Assigns a unique sequential number.

```sql
ROW_NUMBER() OVER(
    ORDER BY salary DESC
)
```

Example:

```sql
SELECT
    name,
    salary,
    ROW_NUMBER() OVER(
        ORDER BY salary DESC
    ) AS row_num
FROM employees;
```

---

# 21. RANK

Same values receive the same rank, with gaps.

```sql
RANK() OVER(
    ORDER BY salary DESC
)
```

Example:

```text
Salary    Rank
100000     1
90000      2
90000      2
80000      4
```

---

# 22. DENSE_RANK

Same values receive the same rank, but **no gaps**.

```sql
DENSE_RANK() OVER(
    ORDER BY salary DESC
)
```

Example:

```text
Salary    Dense Rank
100000        1
90000         2
90000         2
80000         3
```

### ROW_NUMBER vs RANK vs DENSE_RANK

| Function       | Duplicate values | Gaps |
| -------------- | ---------------- | ---- |
| `ROW_NUMBER()` | Different number | No   |
| `RANK()`       | Same rank        | Yes  |
| `DENSE_RANK()` | Same rank        | No   |

---

# 23. Running Total

```sql
SUM(amount) OVER(
    ORDER BY order_date
)
```

Example:

```sql
SELECT
    order_date,
    amount,
    SUM(amount) OVER(
        ORDER BY order_date
    ) AS running_total
FROM orders;
```

---

# 24. CTE — Common Table Expression

CTE creates a temporary named result set that can be used by the following query.

### Basic CTE

```sql
WITH cte_name AS (
    SELECT ...
)
SELECT *
FROM cte_name;
```

### Example

```sql
WITH high_salary AS (
    SELECT *
    FROM employees
    WHERE salary >= 80000
)
SELECT *
FROM high_salary;
```

---

# 25. Multiple CTEs

```sql
WITH cte1 AS (
    SELECT ...
),
cte2 AS (
    SELECT ...
)
SELECT ...
FROM cte2;
```

Example:

```sql
WITH employee_count AS (
    SELECT department, COUNT(*) AS total
    FROM employees
    GROUP BY department
),
large_departments AS (
    SELECT *
    FROM employee_count
    WHERE total >= 5
)
SELECT *
FROM large_departments;
```

---

# 26. Subquery

A query inside another query.

### Example

Find employees earning more than the average salary:

```sql
SELECT *
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
);
```

### CTE vs Subquery

```text
Subquery → Good for simple one-time logic

CTE → Better readability and reusable intermediate steps
```

---

# 27. EXISTS

Checks whether a subquery returns at least one row.

```sql
SELECT *
FROM employees e
WHERE EXISTS (
    SELECT 1
    FROM departments d
    WHERE d.department_id = e.department_id
);
```

---

# 28. UNION vs UNION ALL

### UNION

Combines results and removes duplicates.

```sql
SELECT name FROM employees
UNION
SELECT name FROM managers;
```

### UNION ALL

Combines results and keeps duplicates.

```sql
SELECT name FROM employees
UNION ALL
SELECT name FROM managers;
```

### Remember

```text
UNION      → Removes duplicates
UNION ALL  → Keeps duplicates + usually faster
```

---

# 29. INSERT

Add new records.

```sql
INSERT INTO employees
    (name, department, salary)
VALUES
    ('John', 'IT', 70000);
```

---

# 30. UPDATE

Modify existing records.

```sql
UPDATE employees
SET salary = 75000
WHERE employee_id = 101;
```

⚠️ Always be careful with `UPDATE` without `WHERE`.

```sql
-- Dangerous
UPDATE employees
SET salary = 75000;
```

This updates **every row**.

---

# 31. DELETE

Delete records.

```sql
DELETE FROM employees
WHERE employee_id = 101;
```

⚠️ Without `WHERE`, all rows can be deleted:

```sql
DELETE FROM employees;
```

---

# 32. Primary Key

Uniquely identifies each row.

```sql
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10,2)
);
```

### Primary Key

```text
Unique
NOT NULL
Identifies one row
```

---

# 33. Foreign Key

Creates a relationship between tables.

```sql
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    department_id INT,
    FOREIGN KEY (department_id)
        REFERENCES departments(department_id)
);
```

---

# 34. Common Constraints

```text
PRIMARY KEY
FOREIGN KEY
UNIQUE
NOT NULL
CHECK
DEFAULT
```

Example:

```sql
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2) CHECK (salary > 0),
    status VARCHAR(20) DEFAULT 'ACTIVE'
);
```

---

# 35. Transactions

A transaction groups multiple operations into one logical unit.

### COMMIT

```sql
START TRANSACTION;

-- operation 1
-- operation 2

COMMIT;
```

Changes are permanently saved.

### ROLLBACK

```sql
START TRANSACTION;

-- operation 1
-- operation 2

ROLLBACK;
```

Changes are undone.

> Transaction syntax varies by database. For example, SQL Server commonly uses `BEGIN TRANSACTION`.

---

# 36. ACID

The four properties of database transactions.

| Letter | Meaning     | Explanation                                        |
| ------ | ----------- | -------------------------------------------------- |
| **A**  | Atomicity   | All or nothing                                     |
| **C**  | Consistency | Database remains in a valid state                  |
| **I**  | Isolation   | Concurrent transactions don't improperly interfere |
| **D**  | Durability  | Committed data persists                            |

### Easy Memory Trick

```text
A → All or Nothing
C → Correct/Consistent State
I → Independent Transactions
D → Data Doesn't Disappear
```

---

# 37. SQL Execution Order ⭐

Very important for interviews.

Although we **write**:

```sql
SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
LIMIT
```

SQL logically processes it approximately as:

```text
1. FROM
2. JOIN
3. WHERE
4. GROUP BY
5. HAVING
6. SELECT
7. DISTINCT
8. ORDER BY
9. LIMIT
```

### Example

```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
WHERE salary >= 60000
GROUP BY department
HAVING COUNT(*) >= 2
ORDER BY employee_count DESC
LIMIT 5;
```

Think:

```text
FROM
 ↓
JOIN
 ↓
WHERE
 ↓
GROUP BY
 ↓
HAVING
 ↓
SELECT
 ↓
ORDER BY
 ↓
LIMIT
```

---

# 38. Most Important Patterns ⭐⭐⭐

## Pattern 1 — Find duplicates

```sql
SELECT email, COUNT(*) AS count
FROM employees
GROUP BY email
HAVING COUNT(*) > 1;
```

---

## Pattern 2 — Find second-highest salary

```sql
SELECT MAX(salary)
FROM employees
WHERE salary < (
    SELECT MAX(salary)
    FROM employees
);
```

---

## Pattern 3 — Employees earning above average

```sql
SELECT *
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
);
```

---

## Pattern 4 — Highest salary in each department

```sql
SELECT *
FROM (
    SELECT
        e.*,
        RANK() OVER(
            PARTITION BY department
            ORDER BY salary DESC
        ) AS rnk
    FROM employees e
) x
WHERE rnk = 1;
```

---

## Pattern 5 — Top 3 salaries in each department

```sql
SELECT *
FROM (
    SELECT
        e.*,
        DENSE_RANK() OVER(
            PARTITION BY department
            ORDER BY salary DESC
        ) AS rnk
    FROM employees e
) x
WHERE rnk <= 3;
```

---

## Pattern 6 — Count employees by department

```sql
SELECT
    department,
    COUNT(*) AS employee_count
FROM employees
GROUP BY department
ORDER BY employee_count DESC;
```

---

## Pattern 7 — Departments with average salary > 70000

```sql
SELECT
    department,
    AVG(salary) AS avg_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 70000;
```

---

# 39. SQL Interview Quick Revision ⭐

```text
SELECT       → Choose columns
FROM         → Choose table
WHERE        → Filter rows
JOIN         → Combine tables
GROUP BY     → Create groups
HAVING       → Filter groups
ORDER BY     → Sort
LIMIT        → Restrict rows

COUNT()      → Count
SUM()        → Total
AVG()        → Average
MIN()        → Minimum
MAX()        → Maximum

ROW_NUMBER() → Unique sequence
RANK()       → Ranking with gaps
DENSE_RANK() → Ranking without gaps

CTE          → WITH ...
SUBQUERY     → Query inside query
EXISTS       → Check if rows exist
UNION        → Combine + remove duplicates
UNION ALL    → Combine + keep duplicates

COMMIT       → Save transaction
ROLLBACK     → Undo transaction

PRIMARY KEY  → Unique row identifier
FOREIGN KEY  → Table relationship

ACID
A → Atomicity
C → Consistency
I → Isolation
D → Durability
```

## ⭐ The 10 Things to Know Really Well

If you're preparing for **Java backend / SQL interviews**, prioritize these first:

1. `SELECT / FROM / WHERE`
2. `JOIN` — especially `INNER JOIN` and `LEFT JOIN`
3. `GROUP BY` + aggregate functions
4. `WHERE` vs `HAVING`
5. Subqueries
6. CTEs
7. `ROW_NUMBER`, `RANK`, `DENSE_RANK`
8. `CASE`
9. Primary key / foreign key
10. Transactions + ACID

Then practice these patterns repeatedly:

```text
Find duplicates
Find second-highest salary
Find Nth-highest salary
Top N records
Top N per group
Employees above average
Department-wise aggregation
Running totals
Find missing records using LEFT JOIN
Remove duplicates using ROW_NUMBER()
```
