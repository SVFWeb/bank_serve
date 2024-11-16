package com.example.demo02.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flow {
    private String time;
    private String id;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("financial_type")
    private String financialType;
    @JsonProperty("income_money")
    private Double incomeMoney;
    @JsonProperty("compute_money")
    private Double computeMoney;
    private String remark;

    // Getters and Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFinancialType() {
        return financialType;
    }

    public void setFinancialType(String financialType) {
        this.financialType = financialType;
    }

    public Double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(Double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Double getComputeMoney() {
        return computeMoney;
    }

    public void setComputeMoney(Double computeMoney) {
        this.computeMoney = computeMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}