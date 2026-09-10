SELECT → Choose columns

FROM → Choose table

WHERE → Filter rows

ORDER BY → Sort results

LIMIT → Restrict rows


📊 **JOIN Cheat Sheet**

| JOIN              | Returns                      |
| ----------------- | ---------------------------- |
| `INNER JOIN`      | Only matching records        |
| `LEFT JOIN`       | All left records + matches   |
| `RIGHT JOIN`      | All right records + matches  |
| `FULL OUTER JOIN` | All records from both tables |


🔑 Today's Cheat Sheet
>
>-- Aggregate Functions
> 
>COUNT(*)
>
>SUM(column)
>
>AVG(column)
>
>MIN(column)
>
>MAX(column)


>-- Grouping
> 
>SELECT column, AGGREGATE(column)
FROM table
GROUP BY column;

>-- Filter groups
>
>HAVING AGGREGATE(column) condition;
> 
>Most important pattern
> 
>SELECT department, COUNT(*) AS employee_count
FROM employees
WHERE salary >= 60000
GROUP BY department
HAVING COUNT(*) >= 2
ORDER BY employee_count DESC;



**Basic window function**
>
>AVG(salary) OVER()
>
>Partition
>AVG(salary) OVER(PARTITION BY department)
>
>Row number
>ROW_NUMBER() OVER(ORDER BY salary DESC)
>
>Rank
>RANK() OVER(ORDER BY salary DESC)
>
>Dense Rank
>DENSE_RANK() OVER(ORDER BY salary DESC)
>
>Running total
>SUM(amount) OVER(ORDER BY order_date)