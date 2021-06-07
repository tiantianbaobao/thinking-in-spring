#### Spring IOC overview

- BeanFactory和ApplicationContext的区别以及联系？

- BeanFactory和AApplicationContext的各自的应用场景都有哪些？（各自适用的场景都是什么）

- BeanFactory和FactoryBean<T>的区别？

  - BeanFactory是最基本的IOC容器，是一个标准的抽象工厂的实现（抽象产品）

  - FactoryBean是为了方便创建对象的一个接口，一般说来普通的POJO内部都有有参或者无参的构造器，

    可以直接调用或者通过反射来进行对象的创建或者赋值。但是在很多场景下对象的创建并不是那么容易，所以`FactoryBean`可以帮助我们来创建对象

    - `FactoryBean#getObject()`方法返回创建的具体对象
    - `isSingleton`
    - `SmartFactoryBean`
  