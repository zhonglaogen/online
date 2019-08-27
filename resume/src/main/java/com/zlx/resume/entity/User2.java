package com.zlx.resume.entity;

public class User2 {
    private Integer uId;

    private String uName;

    private String uPassword;

    private Boolean uGender;

    private String uBirth;

    private String uCard;

    private String uEmail;

    private String uTel;

    private String uSchool;

    private String uLocation;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public Boolean getuGender() {
        return uGender;
    }

    public void setuGender(Boolean uGender) {
        this.uGender = uGender;
    }

    public String getuBirth() {
        return uBirth;
    }

    public void setuBirth(String uBirth) {
        this.uBirth = uBirth == null ? null : uBirth.trim();
    }

    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard == null ? null : uCard.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel == null ? null : uTel.trim();
    }

    public String getuSchool() {
        return uSchool;
    }

    public void setuSchool(String uSchool) {
        this.uSchool = uSchool == null ? null : uSchool.trim();
    }

    public String getuLocation() {
        return uLocation;
    }

    public void setuLocation(String uLocation) {
        this.uLocation = uLocation == null ? null : uLocation.trim();
    }
}