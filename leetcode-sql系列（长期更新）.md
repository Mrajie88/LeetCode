---
title: leetcode_sql系列（长期更新）
date: 2019-03-31 20:23:43
tags:
---
本文主要整理刷题思路、逻辑以及相关知识点。
## 175.组合两个表
    select Person.FirstName,Person.LastName,Address.City,Address.State
    from Person left join Address on Person.PersonId = Address.PersonId
tips:注意两表连接种类以及相关语法。表的连接方式有：左连接、右连接、内连接、外连接。
## 176.第二高的薪水
    select IFNULL((select distinct Salary from Employee order by Salary desc limit 1,1),null) as SecondHighestSalary
tips:select distinct 去掉重复值的结果 limit 0,1 表示从第0行开始 要后面的1行。 ifnull(.....,null)函数表示....处如果返回不了需求的结果集则返回null。
## 181.超过经理收入的员工
    select A.Name as Employee
	from Employee A left join Employee B on A.ManagerId = B.Id
	where A.Salary>B.salary
tips:这个题比较坑的地方是需要把返回查询结果列名 as为Employee
## 182.查询重复的电子邮箱
    select Email
	from Person
	where count(Email)>=2
## 183.从不订购的客户
    select Name as Customers
	from Customers
	where Id not in ( select CustomerId from Orders)
## 196.删除重复邮箱
    delete p1 from Person p1,Person p2
    where p1.Email = p2.Email and p1.Id>p2.Id
tips:防止思维盲点。本题考查delete语句。我们通过自连接来处理复杂删除约束条件，这样方便处理。
## 197.上升的温度
    select w1.Id
	from Weather w1 join Weather w2 on    DATEDIFF(w1.RecordDate,w2.RecordDate) = 1
	where w1.Temperature>w2.Temperature
tips:本题关键在于处理日期数据。dateiff(开始事件，结束时间) 为开始时间和结束时间的差值。
## 595.大的国家
    select name,population,area
	from World
	where area>3000000 or population>25000000
## 596.超过5名学生的课
    select class
	from courses
	group by class
	having count(distinct student)>=5
tips:考察聚合函数和去重关键字的联合使用。