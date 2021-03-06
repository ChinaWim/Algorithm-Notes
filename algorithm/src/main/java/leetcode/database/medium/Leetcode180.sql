/**
 * [连续出现的数字]

表：Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。
 

编写一个 SQL 查询，查找所有至少连续出现三次的数字。

返回的结果表中的数据可以按 任意顺序 排列。

 

查询结果格式如下面的例子所示：

 

Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+

Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
1 是唯一连续出现至少三次的数字。


 */


-- select distinct num from logs t1 , (
-- select num from logs
--  group by num having count(id) >= 3) t2
--  where t1.num = t2.num and num in (select )

select distinct num ConsecutiveNums from logs t1
where num = (
select num from logs where id in ( t1.id + 2,t1.id + 1) group by num having count(num) = 2
)


