package com.example.demo02.domain;

public class contract {

    private String uid;

    private String cid;
    private String cName;
    private  Integer cLoanAmount;
    private  String cTime;



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcLoanAmount() {
        return cLoanAmount;
    }

    public void setcLoanAmount(Integer cLoanAmount) {
        this.cLoanAmount = cLoanAmount;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

}
