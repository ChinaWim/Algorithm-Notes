/**
 * [部门工资前三高的所有员工]

Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 85000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
| 7  | Will  | 70000  | 1            |
+----+-------+--------+--------------+
Department 表包含公司所有部门的信息。

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 85000  |
| IT         | Will     | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+


 */


-- select t2.name department,t1.name employee,t1.salary from employee t1 ,department t2,(select e.id,(select count(*) from employee  where departmentId = e.departmentId and Salary > e.Salary )  count   from employee e ) temp
-- where t1.id = temp.id  and t2.id = t1.departmentId and temp.count <= 2
-- order by t2.id,t1.salary desc




select t2.name department,t1.name employee,t1.salary from employee t1 ,department t2,
(select e.id,(
    select count(*) from (select departmentId,salary from employee group by departmentId,salary) groupTemp
     where groupTemp.departmentId = e.departmentId and groupTemp.salary > e.salary
 )  count
    from employee e ) temp

where t1.id = temp.id  and t2.id = t1.departmentId and temp.count <= 2
order by t2.id,t1.salary desc









