package org.tianbao.thinking.in.spring.ioc.overview.model;

import java.io.Serializable;

/***
 * @description User
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-04-02 17:33
 * @since V1.0.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7287118853586635530L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
