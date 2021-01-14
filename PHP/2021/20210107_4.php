<?php

function isFirstCategorySame($data)
{
    $origin_course_id = Arr::get($data, 'origin_course_id');
    $target_course_id = Arr::get($data, 'target_course_id');
    if (empty($origin_course_id) || empty($target_course_id)) {
        return false;
    }

    $category_level1 = (new self())->getOne(['course_id'=>$origin_course_id], 'category_level');
    $category_level2 = (new self())->getOne(['course_id'=>$target_course_id], 'category_level');
    $category_level1 = Arr::get($category_level1, 'category_level');
    $category_level2 = Arr::get($category_level2, 'category_level');
    if (empty($category_level1) || empty($category_level2)) {
        return false;
    }

    return explode('-', $category_level1)[0] == explode('-', $category_level2)[0];
}
