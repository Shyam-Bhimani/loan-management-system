select * from employeemaster.employees;

select name,salary from employeemaster.employees;

select * from employeemaster.employees where city='Pune';

select * from employeemaster.employees where salary>70000;

select * from employeemaster.employees where department='IT' and salary>=75000;

select * from employeemaster.employees where city in('Mumbai','Pune');

select * from employeemaster.employees where salary between 60000 and 80000;

select * from employeemaster.employees where name like 'R%';

select * from employeemaster.employees where not department='HR';

select * from employeemaster.employees order by salary desc limit 3;

select * from employeemaster.employees where department in('IT','Sales') order  by salary desc