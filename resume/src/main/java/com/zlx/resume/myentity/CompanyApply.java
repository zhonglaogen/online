package com.zlx.resume.myentity;

public class CompanyApply {
    private Integer caId;
    private Integer cuId;
    /**
     * 申请码
     */
    private String cRegistcode;

    private int aResult;

    /**
     * 申请公司id
     */
    private int cId;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getaResult() {
        return aResult;
    }

    public void setaResult(int aResult) {
        this.aResult = aResult;
    }

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getcRegistcode() {
        return cRegistcode;
    }

    public void setcRegistcode(String cRegistcode) {
        this.cRegistcode = cRegistcode;
    }

    @Override
    public String toString() {
        return "CompanyApply{" +
                "caId=" + caId +
                ", cuId=" + cuId +
                ", cRegistcode='" + cRegistcode + '\'' +
                ", aResult=" + aResult +
                '}';
    }
}
