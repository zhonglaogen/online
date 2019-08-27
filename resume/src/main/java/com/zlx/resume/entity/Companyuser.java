package com.zlx.resume.entity;

public class Companyuser {
    private Integer cuId;

    private String cuPassword;

    private String cuName;

    private String cuBirth;

    private String cuTel;

    private String cuEamil;

    private Integer cId;

    private Boolean cuGender;

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getCuPassword() {
        return cuPassword;
    }

    public void setCuPassword(String cuPassword) {
        this.cuPassword = cuPassword == null ? null : cuPassword.trim();
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName == null ? null : cuName.trim();
    }

    public String getCuBirth() {
        return cuBirth;
    }

    public void setCuBirth(String cuBirth) {
        this.cuBirth = cuBirth == null ? null : cuBirth.trim();
    }

    public String getCuTel() {
        return cuTel;
    }

    public void setCuTel(String cuTel) {
        this.cuTel = cuTel == null ? null : cuTel.trim();
    }

    public String getCuEamil() {
        return cuEamil;
    }

    public void setCuEamil(String cuEamil) {
        this.cuEamil = cuEamil == null ? null : cuEamil.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Boolean getCuGender() {
        return cuGender;
    }

    public void setCuGender(Boolean cuGender) {
        this.cuGender = cuGender;
    }
}