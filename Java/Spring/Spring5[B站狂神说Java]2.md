# Spring5[B站狂神说Java]

### 7.bean的自动注解
* 自动装配是Spring满足bean依赖的一种方式，有三种方式：
* 1）在xml中显示的配置  
* 2）在java中显示的配置  
* 3）隐式的自动装配bean  
    ByName 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid，
                并且需要保证bean的id值唯一  
    ByType 会自动在容器上下文中查找，和自己对象属性类型相同的beanid，
                并且需要保证bean的class值唯一   
* 4）使用注解实现自动装配  
    jdk1.5支持的注解，Spring2.5就支持注解了   
    使用注解须知：  
    a.导入约束：context约束  
    b.配置注解的支持：`<context:annotation-config/>`  
    @Autowired   
    直接在属性上使用即可，也可以在set上使用  
    使用Autowired我们可以不用编写set方法，前提是该属性在容器中存在，且符合ByName   
    @nullable  
    字段标记了这个注解，说明这个字段可以为null  
    @Resource(name="myMovieFinder")   
    @Autowared 和 @Resource 区别  
    @Autowared 通过ByName方式实现，而且要求这个对象必须存在 [常用]  
    @Resource 默认通过ByName方式实现，找不到名字则ByType，都找不到就报错

### 8.Spring 注解开发
* 8.1 bean配置文件
* 8.2 属性如何注入  
    @Component  注解类  
    @Value("zhangsan") 注解属性值
* 8.3 衍生的注解  
    @Component 有几个衍生注解，会按照MVC结构分层  
    dao层使用 @Repository  
    controller层使用 @Controller  
    service层使用 @Service  
    这四个注解的功能都是一样的，都是代表将某个类注册到Spring中，装配bean 
* 8.4 自动装配置  
    @Autowared   
    @Resource  
* 8.5 作用域  
    @Scope("singleton") 单例模式  
    @Scope("prototype") 原型模式
* 8.6 XML与注解比较  
    xml更方便万能，适用于任何场合，维护简单方便  
    注解不是自己的类使用不了，维护相对复杂  
    最佳实践：  
    xml用来管理bean; 注解只负责属性的注入    
    注意事项：  
    需要让注解生效，必须开放对注解的支持  
    `<context:annotation-config/>`   
    `<context:component-scan base-package="" />`
