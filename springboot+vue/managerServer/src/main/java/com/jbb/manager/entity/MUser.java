package com.jbb.manager.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName MUser
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:02
 **/
@Entity
@Table(name = "m_user", schema = "manager", catalog = "")
public class MUser {
    private int id;
    private String realName;
    private String username;
    private String password;
    private int userStatus;
    private String phone;
    private String address;
    private String headImg;
    private Timestamp loginTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_status")
    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "head_img")
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Basic
    @Column(name = "login_time")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MUser mUser = (MUser) o;
        return id == mUser.id &&
                userStatus == mUser.userStatus &&
                Objects.equals(realName, mUser.realName) &&
                Objects.equals(username, mUser.username) &&
                Objects.equals(password, mUser.password) &&
                Objects.equals(phone, mUser.phone) &&
                Objects.equals(address, mUser.address) &&
                Objects.equals(headImg, mUser.headImg) &&
                Objects.equals(loginTime, mUser.loginTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, realName, username, password, userStatus, phone, address, headImg, loginTime);
    }
}
