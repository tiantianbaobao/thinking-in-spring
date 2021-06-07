package org.tianbao.thinking.in.spring.ioc.overview.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.tianbao.thinking.in.spring.ioc.overview.model.User;

import java.util.Map;

/***
 * @description ioc container demo
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 11:03
 * @since V1.0.0
 */
public class BeanFactoryAsIocContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:META-IF/dependency-lookup.xml";
        int beanDefinitions = reader.loadBeanDefinitions(location);
        System.err.println("beanDefinitions -> " + beanDefinitions);
        lookupCollectionByType(beanFactory);
    }

    public static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.err.println("查找所有类型为User的bean ->" + beansOfType);
        }
    }
}
