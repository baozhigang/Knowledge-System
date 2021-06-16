<?php

/**
  * 快速排序法:
  * 1.选择一个参考单元，比大小将数组分割成两个部分
  * 2.递归对两个部分进行排序，此时注意避免无线分割，当数组数量小于1时返回数组
  * 3.将两个部分和参考单元组合起来，返回   
  * 4.注意数组的赋值格式 $left[] $base[0]
  * 5.循环跳过参考值从$i=1开始  
  */

$arr = array(20,13,11,48,9,25,50,1,14,100,40,25);
function quickSort($arr) {
    if (count($arr) < 2) {
        return $arr;
    }
    $base[] = $arr[0];
    $left = $right = [];
    for ($i = 1; $i < count($arr); $i++) {
        if ($arr[$i] > $base[0]) {
            $right[] = $arr[$i];
        } else {
            $left[] = $arr[$i];
        }
    }
    $left = quickSort($left);
    $right = quickSort($right);
    return array_merge($left, $base, $right);
}

var_dump(quickSort($arr));
