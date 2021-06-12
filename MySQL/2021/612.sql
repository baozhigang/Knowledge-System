select waybillno from waybillinfo where zonecode='中山公园' and optype='异常派件' 
group by waybillno having count(*) > 3;

select * into seniordrivers from drivers where drivedistanced >=5000;

select sno,
sum(if(class='english',score,0)) as english,
sum(if(class='math',score,0)) as math,
from sc
where class in('english', 'math')
group by sno;

ALTER TABLE test_tb1 ALTER i SET DEFAULT 1000;
