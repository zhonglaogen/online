package com.zlx.resume.rabitmq;

public class MailAddress {

    private String oMail;
    private String nMail;
    private Integer cuId;

    public MailAddress() {
    }

    public MailAddress(String oMail, String nMail, Integer cuId) {
        this.oMail = oMail;
        this.nMail = nMail;
        this.cuId = cuId;
    }

    public String getoMail() {
        return oMail;
    }

    public void setoMail(String oMail) {
        this.oMail = oMail;
    }

    public String getnMail() {
        return nMail;
    }

    public void setnMail(String nMail) {
        this.nMail = nMail;
    }


    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

}
