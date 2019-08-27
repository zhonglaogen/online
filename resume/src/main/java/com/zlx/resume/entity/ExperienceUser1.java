package com.zlx.resume.entity;

public class ExperienceUser1 {
    private Integer eId;

    private Integer uId;

    private Integer cId;

    private String eStart;

    private String eEnd;

    private String eRole;

    private String eBehaviour;

    private String eReason;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String geteStart() {
        return eStart;
    }

    public void seteStart(String eStart) {
        this.eStart = eStart == null ? null : eStart.trim();
    }

    public String geteEnd() {
        return eEnd;
    }

    public void seteEnd(String eEnd) {
        this.eEnd = eEnd == null ? null : eEnd.trim();
    }

    public String geteRole() {
        return eRole;
    }

    public void seteRole(String eRole) {
        this.eRole = eRole == null ? null : eRole.trim();
    }

    public String geteBehaviour() {
        return eBehaviour;
    }

    public void seteBehaviour(String eBehaviour) {
        this.eBehaviour = eBehaviour == null ? null : eBehaviour.trim();
    }

    public String geteReason() {
        return eReason;
    }

    public void seteReason(String eReason) {
        this.eReason = eReason == null ? null : eReason.trim();
    }
}