package com.sunniwell.weixin.bean.operator;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xiaojian on 2018/2/11.
 */
@Table(name = "operator")
public class OperatorBean {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private long loginUtc;
    private String creatorId = "";
    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getLoginUtc() {
        return loginUtc;
    }

    public void setLoginUtc(long loginUtc) {
        this.loginUtc = loginUtc;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
