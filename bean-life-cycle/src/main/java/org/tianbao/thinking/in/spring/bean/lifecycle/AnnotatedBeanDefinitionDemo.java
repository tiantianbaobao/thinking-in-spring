package org.tianbao.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/***
 * @description 面向注解的BeanDefinition
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-04-02 14:47
 * @since V1.0.0
 */
public class AnnotatedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(registry);
        int beanDefinitionBeforeCounter = registry.getBeanDefinitionCount();
        //注册当前类，未标注@Component的类
        annotatedBeanDefinitionReader.register(AnnotatedBeanDefinitionDemo.class);
        int beanDefinitionAfterCounter = registry.getBeanDefinitionCount();
        System.out.println("当前注册了的bean ：" + (beanDefinitionAfterCounter - beanDefinitionBeforeCounter));
        AnnotatedBeanDefinitionDemo registryBean = (AnnotatedBeanDefinitionDemo) registry.getBean("annotatedBeanDefinitionDemo");
        System.out.println("获取当前的注册的bean：" + registryBean);
    }
}
