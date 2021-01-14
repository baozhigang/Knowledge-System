<?php
//PHP计算两个时间差的方法
$startdate="2010-12-11 11:40:00";
$enddate="2012-12-12 11:45:09";
$date=floor((strtotime($enddate)-strtotime($startdate))/86400);
$hour=floor((strtotime($enddate)-strtotime($startdate))%86400/3600);
$minute=floor((strtotime($enddate)-strtotime($startdate))%86400/60);
$second=floor((strtotime($enddate)-strtotime($startdate))%86400%60);

echo $date."天";
echo $hour."小时";
echo $minute."分钟";
echo $second."秒";
?>