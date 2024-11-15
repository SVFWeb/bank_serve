package com.example.demo02.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("users")
public class Users {
    @TableId("uid")
    private String uid;
    private String userName;
    private  Integer uAge;
    private  String uEthnicGroup;
    private  Integer uSex;
    private  String uPhone;
    private  String uAccountPassword;
    private  Integer uPaymentPassword;
    private  Double uBalance;
    private  Double uLiability;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuEthnicGroup() {
        return uEthnicGroup;
    }

    public void setuEthnicGroup(String uEthnicGroup) {
        this.uEthnicGroup = uEthnicGroup;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAccountPassword() {
        return uAccountPassword;
    }

    public void setuAccountPassword(String uAccountPassword) {
        this.uAccountPassword = uAccountPassword;
    }

    public Integer getuPaymentPassword() {
        return uPaymentPassword;
    }

    public void setuPaymentPassword(Integer uPaymentPassword) {
        this.uPaymentPassword = uPaymentPassword;
    }

    public Double getuLiability() {
        return uLiability;
    }

    public void setuLiability(Double uLiability) {
        this.uLiability = uLiability;
    }

    public Double getuBalance() {
        return uBalance;
    }

    public void setuBalance(Double uBalance) {
        this.uBalance = uBalance;
    }


}
