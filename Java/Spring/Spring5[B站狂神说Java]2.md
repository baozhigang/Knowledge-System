# Spring5[B站狂神说Java]

### 7.bean的自动注解
        自动装配是Spring满足bean依赖的一种方式，有三种方式：
        1）在xml中显示的配置
        2）在java中显示的配置
        3）隐式的自动装配bean
            ByName 会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanid，
                并且需要保证bean的id值唯一
            ByType 会自动在容器上下文中查找，和自己对象属性类型相同的beanid，
                并且需要保证bean的class值唯一   
        4）使用注解实现自动装配
            jdk1.5支持的注解，Spring2.5就支持注解了 
            使用注解须知：
                a.导入约束：context约束
                b.配置注解的支持：<context:annotation-config/>
                @Autowired 
                直接在属性上使用即可，也可以在set上使用
                使用Autowired我们可以不用编写set方法，前提是该属性在容器中存在，且符合ByName 
                @nullable 字段标记了这个注解，说明这个字段可以为null
                @Resource(name="myMovieFinder") 
                @Autowared 和 @Resource  区别
                @Autowared 通过ByName方式实现，而且要求这个对象必须存在 [常用]
                @Resource 默认通过ByName方式实现，找不到名字则ByType，都找不到就报错
