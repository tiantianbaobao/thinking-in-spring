package org.tianbao.thinking.in.java.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tianbao.thinking.in.java.spring.model.User;

/***
 * @description Bean的常规实例化 {@link org.tianbao.thinking.in.java.spring.model.User}
 * 的{@link org.springframework.beans.factory.FactoryBean}的实现方式
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 22:38
 * @since V1.0.0
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation.xml");
        User userByStaticFactoryMethod = beanFactory.getBean("user-static-factory-method", User.class);
        User userByFactoryBean = beanFactory.getBean("userFactory", User.class);
        User userByInstantiationObject = beanFactory.getBean("userByInstantiationObject", User.class);
        System.err.println("userByStaticFactoryMethod -> " + userByStaticFactoryMethod);
        System.err.println("userByFactoryBean -> " + userByFactoryBean);
        System.err.println("userByInstantiationObject -> " + userByInstantiationObject);
    }
}
