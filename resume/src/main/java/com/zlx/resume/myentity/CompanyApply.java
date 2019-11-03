package com.zlx.resume.myentity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用于请求关联公司的相关信息")
public class CompanyApply {
    @ApiModelProperty(name = "申请id")
    private Integer caId;
    @ApiModelProperty(name = "此人的id",required = true)
    private Integer cuId;
    /**
     * 申请码
     */
    @ApiModelProperty(name = "申请码",required = true)
    private String cRegistcode;

    @ApiModelProperty(name = "申请结果")
    private int aResult;

    /**
     * 申请公司id
     */
    @ApiModelProperty(name = "申请公司id",required = true)
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
