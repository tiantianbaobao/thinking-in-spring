package org.tianbao.thinking.in.java.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.tianbao.thinking.in.java.spring.model.User;

/***
 * @description {@link User}的{@link FactoryBean}
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 22:39
 * @since V1.0.0
 */
public class UserFactory implements FactoryBean<User>{

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
