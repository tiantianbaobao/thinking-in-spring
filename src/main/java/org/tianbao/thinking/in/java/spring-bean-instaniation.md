### Spring Bean Instantiation
- 如何实例化Bean

    - 常规方式

        - 构造器

        - 静态工厂

        - bean的工厂方法

        - 通过FactoryBean<?>

          ````xml
          <?xml version="1.0" encoding="UTF-8"?>
          <beans xmlns="http://www.springframework.org/schema/beans"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xmlns:aop="http://www.springframework.org/schema/aop"
                 xmlns:context="http://www.springframework.org/schema/context"
                 xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
          
                  <!-- FactoryBean实例化方法 -->
                  <bean id="userFactory" class="org.tianbao.thinking.in.java.spring.bean.UserFactory"/>
                  <!-- 静态工厂 -->
                  <bean id="user-static-factory-method" class="org.tianbao.thinking.in.java.spring.model.User" factory-method="createUser"/>
          
                  <!-- 实力工厂 -->
                  <bean id="userByInstantiationObject" factory-bean="userInstantiationFactory" factory-method="createUser"/>
                  <bean id="userInstantiationFactory" class="org.tianbao.thinking.in.java.spring.bean.DefaultUserInstantiation"/>
          
          </beans>
          ````



- 非常规方式

    - `ServiceLoaderFactoryBean` 原则上还是借鉴了jdk的`ServiceLoader`机制实现的

    - `AutowireCapableBeanFactory#createBean`

    - `BeanDefinitionRegistry#registryBeanDefinition`

      ````java
      org.tianbao.thinking.in.java.spring.bean.UserInstantiation
      ````

      ````java
      public class SpecialBeanInstantiationDemo {
          public static void main(String[] args) {
      //        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation.xml");
              ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation.xml");
              AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
              ServiceLoader<UserInstantiation> serviceLoader = beanFactory.getBean("userInstantiationServiceLoader", ServiceLoader.class);
              displayServiceLoader(serviceLoader);
      
              UserInstantiation factoryBean = autowireCapableBeanFactory.createBean(DefaultUserInstantiation.class);
              System.err.println("AutowireCapableBeanFactory#createBean -> " + factoryBean.createUser());
          }
      
          private static void displayServiceLoader(ServiceLoader<UserInstantiation> serviceLoader) {
              Iterator<UserInstantiation> iterator = serviceLoader.iterator();
              while (iterator.hasNext()) {
                  UserInstantiation userInstantiation = iterator.next();
                  System.err.println(userInstantiation.createUser());
              }
          }
      }
      ````



      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns:aop="http://www.springframework.org/schema/aop"
             xmlns:context="http://www.springframework.org/schema/context"
             xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
      
              <!-- 通过ServiceLoaderFactoryBean -->
              <bean id="userInstantiationServiceLoader" class="org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean">
                   <property name="serviceType" value="org.tianbao.thinking.in.java.spring.bean.UserInstantiation"/>
              </bean>
      
      </beans>
      ````

