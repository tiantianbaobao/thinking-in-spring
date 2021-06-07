package org.tianbao.thinking.in.java.spring.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.tianbao.thinking.in.java.spring.model.User;

import java.util.Map;

/***
 * @description {@link BeanDefinition}
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 12:11
 * @since V1.0.0
 *
**/
public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //1、通过BeanDefinitionBuilder创建BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "123")
                .addPropertyValue("id", 12);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //2、通过AbstractBeanDefinition及其派生子类创建BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        //MutablePropertyValues添加对象属性
        MutablePropertyValues ma = new MutablePropertyValues();
        ma.addPropertyValue("id", 21);
        ma.addPropertyValue("name", "4343");
        //或者通过add的链式操作
//        ma.add("age", 333).add("name", "nnn");
        genericBeanDefinition.setPropertyValues(ma);


        beanFactory.registerBeanDefinition("user1", beanDefinition);
        beanFactory.registerBeanDefinition("user2", genericBeanDefinition);

        Map<String, User> beans = beanFactory.getBeansOfType(User.class);
        System.err.println("User beans -> " + beans);

    }
}
