package com.szxy.spdb.po;

public class User {
    /**
    *主键uid
    */
    private Integer uid;

    /**
    *用户名，账号
    */
    private String username;

    /**
    *密码
    */
    private String password;

    /**
    *真实姓名
    */
    private String name;

    /**
    *出生日期
    */
    private String birthday;

    /**
    *男或女
    */
    private String sex;

    /**
    *手机号
    */
    private String telephone;

    /**
    *邮箱
    */
    private String email;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}