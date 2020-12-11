# Java知识点记录

### 1.基本概念

##### 1.1  Java 不支持整数类型测试，因为integer与boolean是两种类型，并不相容
* 如 int x = 1; while(x) {}  是❎的
* 如 boolean isHot = true; while(isHot) {}  是✔️的 

##### 1.2 Java中全局的函数与数据
* 首先任何Java中的事物都必须呆在类中。
* 因此pi常数或random()方法也必须定义在Math这个类中。这个近似全局的事物在Java中是个例外，他们是非常特殊的情况，不会有多个实例或者对象。

##### 1.2 基本数据类型
* 生命浮点型变量 float f = 32.5f;  
  后面要加上f,否则会被当成double处理
* 变量有两种：primitive主数据类型和引用  
* 应用变量的值代表位于堆之对象的存储方法  
* 数组一定是个对象，不管所声明的元素是否为primitive主数据类型，  
  并没有primitive主数据类型的数组，只有装载primitive主数据类型的数组  
