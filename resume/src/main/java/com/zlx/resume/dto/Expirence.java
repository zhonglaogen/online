package com.zlx.resume.dto;

public class Expirence {
    private String uCard;
    private String cuId;
    private String cId;
    private String eStartTime;
    private String eEndTime;
    private String eRole;
    private String eBehavior;
    private String eReason;

    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard;
    }

    public String getCuId() {
        return cuId;
    }

    public void setCuId(String cuId) {
        this.cuId = cuId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String geteStartTime() {
        return eStartTime;
    }

    public void seteStartTime(String eStartTime) {
        this.eStartTime = eStartTime;
    }

    public String geteEndTime() {
        return eEndTime;
    }

    public void seteEndTime(String eEndTime) {
        this.eEndTime = eEndTime;
    }

    public String geteRole() {
        return eRole;
    }

    public void seteRole(String eRole) {
        this.eRole = eRole;
    }

    public String geteBehavior() {
        return eBehavior;
    }

    public void seteBehavior(String eBehavior) {
        this.eBehavior = eBehavior;
    }

    public String geteReason() {
        return eReason;
    }

    public void seteReason(String eReason) {
        this.eReason = eReason;
    }
}
