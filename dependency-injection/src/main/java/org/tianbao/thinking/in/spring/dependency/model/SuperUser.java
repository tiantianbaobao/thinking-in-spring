package org.tianbao.thinking.in.spring.dependency.model;

/***
 * @description SuperUser extends {@link User}
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-04-02 17:34
 * @since V1.0.0
 */
public class SuperUser extends User{

    private static final long serialVersionUID = -2006714490502755218L;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
