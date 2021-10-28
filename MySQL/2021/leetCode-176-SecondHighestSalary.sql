/**
 * 查询第二高薪水
 * 不存在则返回null
 */
SELECT
    IFNULL(
    (SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1,1), NULL)
    AS SecondHighestSalary;



