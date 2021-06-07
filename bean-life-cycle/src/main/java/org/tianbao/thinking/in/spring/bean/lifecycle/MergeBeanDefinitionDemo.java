package org.tianbao.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.tianbao.thinking.in.spring.model.User;
import org.tianbao.thinking.in.spring.model.SuperUser;

/***
 * @description Merge BeanDefinition demo
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-04-02 17:41
 * @since V1.0.0
 */
public class MergeBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        //xml bean definition resource
        String location = "MATE-INF/bean-lifecycle.xml";
        definitionReader.loadBeanDefinitions(location);
        User user = (User) beanFactory.getBean("user");
        SuperUser superUser = (SuperUser) beanFactory.getBean("superUser");
        System.err.println("user -> " + user);
        System.err.println("superUser -> " + superUser);
    }
}
