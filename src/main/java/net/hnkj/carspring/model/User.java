package net.hnkj.carspring.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class User implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String salt;

    private Date createdate;

    private Integer status;

    public User(Integer userid, String username, String password, String salt, Date createdate, Integer status) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createdate = createdate;
        this.status = status;
    }

    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}