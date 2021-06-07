package org.tianbao.thinking.in.java.spring.bean;

import org.tianbao.thinking.in.java.spring.model.User;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-06-06 22:54
 * @since V1.0.0
 */
public interface UserInstantiation {
    default User createUser() {
        User user = new User();
        user.setId(333);
        user.setName("333333");
        return user;
    }
}
