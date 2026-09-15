SELECT c.name, o.product
FROM customers c
INNER JOIN orders o
ON c.customer_id = o.customer_id;

SELECT *
FROM customers c
LEFT JOIN orders o
ON c.customer_id=o.customer_id;

SELECT *
FROM customers c
LEFT JOIN orders o
ON c.customer_id=o.customer_id
where o.order_id is NULL;

SELECT c.customer_id, c.name, o.product, o.amount
FROM customers c
INNER JOIN orders o
ON c.customer_id=o.customer_id
WHERE o.amount>10000;

--Find all customers from Pune and their orders.
SELECT *
FROM customers c
INNER JOIN orders o
ON c.customer_id=o.customer_id
WHERE c.city='Pune'

--Find all customers who have placed at least one order.
SELECT DISTINCT c.customer_id, c.name
FROM customers c
INNER JOIN orders o
ON c.customer_id=o.customer_id;

--Find customers who have never placed an order.
SELECT c.name,o.product,o.amount
FROM customers c
INNER JOIN orders o
ON c.customer_id=o.customer_id
WHERE o.order_id IS NULL;

--Get customer name, product and amount, sorted by amount from highest to lowest.
SELECT c.name,o.product, o.amount
FROM customers c
INNER JOIN orders o
ON c.customer_id=o.customer_id
ORDER BY o.amount desc;