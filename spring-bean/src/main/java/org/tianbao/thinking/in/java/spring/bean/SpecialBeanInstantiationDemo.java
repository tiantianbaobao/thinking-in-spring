package org.tianbao.thinking.in.java.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/***
 * @description
 * 特殊的Bean的实例化方式
 * 常规的实例化方式
 *  1）、构造器
 *  2）、静态工厂 xml的bean定义中的factory-method
 *  3）、工厂方法 xml的bean定义中的factory-bean
 *  4）、FactoryBean<T>
 * 非常规
 *  1）、ServiceLoaderFactoryBean
 *  2）、AutowireCapableBeanFactory#createBean
 *  3）、BeanDefinitionRegistry#registryBeanDefinition
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 22:29
 * @since V1.0.0
 */
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
