package org.tianbao.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tianbao.thinking.in.spring.dependency.model.User;

import java.util.Collection;
import java.util.Optional;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-09 22:30
 * @since V1.0.0
 */
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired       //依赖注入
    private User user;//DependencyDescriptor
                      // required == true (@Autowired#required)
                      // 实时注入 eager == false(lazy == false)
                      // 通过类型 class
                      // 字段 filed
                      //primary == true

    @Autowired
    private Collection<User> users;

    @Autowired
    private Optional<User> userOptional;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyInjectionResolutionDemo.class);
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        String location = "classpath:META-INF/dependency-injection-context.xml";
        beanDefinitionReader.loadBeanDefinitions(location);

        context.refresh();

        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean(User.class);
        System.err.println(user1);
        System.err.println(user2);
        context.close();
    }
}
