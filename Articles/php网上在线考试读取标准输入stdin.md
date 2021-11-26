### 常用指令

```php
<?php
    fscanf(STDIN, "%d", $n);  //整数
    fscanf(STDIN, "%s", $str); //字符串
    fscanf(STDIN, "%[^\n]", $cc); //整行数据
    fscanf(STDIN, "%d %d", $a, $b);

    // 获取20行数据到数组$map中
    for ($i=0; $i<20; $i++) {
        fscanf(STDIN, "%[^\n]", $map[$i]);
    }

