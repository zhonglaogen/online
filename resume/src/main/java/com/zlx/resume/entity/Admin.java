package com.zlx.resume.entity;

public class Admin {
    private Integer aId;

    private String aPassword;

    private String aTel;

    private String aCard;

    private String aMail;

    private String aName;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public String getaTel() {
        return aTel;
    }

    public void setaTel(String aTel) {
        this.aTel = aTel == null ? null : aTel.trim();
    }

    public String getaCard() {
        return aCard;
    }

    public void setaCard(String aCard) {
        this.aCard = aCard == null ? null : aCard.trim();
    }

    public String getaMail() {
        return aMail;
    }

    public void setaMail(String aMail) {
        this.aMail = aMail == null ? null : aMail.trim();
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }
}