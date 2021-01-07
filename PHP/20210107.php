<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>实现计算器</title>
    </head>
    <body>
        <h3>实现一个计算器</h3>
        <form action="./compute.php" method="get">
            第一个数：<input type="number" name="num1">


            请选择运算方式：
                <input type="radio" name="type" value="+">+
                <input type="radio" name="type" value="-">-
                <input type="radio" name="type" value="*">*
                <input type="radio" name="type" value="/">/


            第二个数：<input type="number" name="num2">


            <input type="submit" value="提交">
        </form>
    </body>
    <?php
        // 第一步 获取用户输入的数据，选择的运算方式
        $num1 = $_GET['num1'];       
        $type = $_GET['type'];       
        $num2 = $_GET['num2'];       

        // 第二步 按照运算方式的不同，进行不同的运算
        switch($type){
            case '+':
                $result = $num1 + $num2;
            break;
            case '-':
                 $result = $num1 - $num2;
            break;
            case '*':
                 $result = $num1 * $num2;
            break;
            case '/':
                if($num2!=0){
                     $result = $num1 / $num2;
                }else{
                    echo '<font color="red">除数不能为0</font>';
                    exit;
                }
            break;
        }

        // 第三步 输出结果
        if(isset($num1)&&isset($num2)&&isset($type)){
            echo $num1.$type.$num2.'='. $result;
        }
    ?>
</html>