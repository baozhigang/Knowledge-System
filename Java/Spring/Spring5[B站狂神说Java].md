# Spring5[B站狂神说Java]

### 1.Spring

##### 1.1简介
        2002年首次推出spring框架的雏形：interface21框架！
        2004年3月24日首次发布1.0正式版本
        Rod Johnson,  Spring Framework创始人，悉尼大学音乐博士
        理念：使现有的技术更容易使用
        官网： https://spring.io/projects/spring-framework 
        github: https://github.com/spring-projects/spring-framework  
        导入依赖包： https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.11.RELEASE

##### 1.2 优点
        开源  轻量级  非入侵式框架
        控制反转（IOC）、面向切面编程（AOP）
        支持事务处理、对框架整合的支持 

##### 1.3 七大核心模块
        核心容器(Spring Core)
        应用上下文(Spring Context)
        面向切面编程 (Spring AOP)
        JDBC和DAO模块（Spring DAO）
        对象实体映射（Spring ORM）
        Web模块（Spring Web）
        MVC模块（Spring Web MVC）

##### 1.4 拓展
        Spring Boot 构建一切。快速开发单个微服务
        Spring Cloud 协调一切
##### 2. IOC 理论推导
        控制反转IOC(Inversion of Control)，是一种设计思想，DI(依赖注入)是实现IOC的一种方法
        控制反转是一种通过描述(XML或注解)并通过第三方去生产或获取特定对象的方式，在Spring中实现控制反转的是IOC容器，其实现方法是依赖注入(Dependency Injection)

##### 3. HelloSpring 
    对象由Spring来创建、管理、分配

##### 4. IOC 创建对象的方式
        new ClassPathXmlApplicationContext("beans.xml");

##### 5.Spring 配置
        别名，bean的配置，import导入

##### 6. 依赖注入
        构造器注入、  set注入、 其他注入 
        作用域：
        单例模式：<bean id="accountService" class="com.something.DefaultAccountService" scope="singleton"/> 
        原型模式：<bean id="accountService" class="com.something.DefaultAccountService" scope="prototype"/> 


