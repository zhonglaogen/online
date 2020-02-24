package com.zlx.resume.entity;

public class Company {
    private Integer cId;

    private String cName;

    private String cLocation;

    private String cRegistcode;

    private Integer cRealy;

    private String cDescribe;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcLocation() {
        return cLocation;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation == null ? null : cLocation.trim();
    }

    public String getcRegistcode() {
        return cRegistcode;
    }

    public void setcRegistcode(String cRegistcode) {
        this.cRegistcode = cRegistcode == null ? null : cRegistcode.trim();
    }

    public Integer getcRealy() {
        return cRealy;
    }

    public void setcRealy(Integer cRealy) {
        this.cRealy = cRealy;
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe == null ? null : cDescribe.trim();
    }
}