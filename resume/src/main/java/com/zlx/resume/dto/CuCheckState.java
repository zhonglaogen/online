package com.zlx.resume.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用来存储公司用户的id和验证码和用户身份证号码
 */
@ApiModel(description = "用来存储公司用户的id和验证码和用户身份证号码,主要是通过这些信息检验用户是否具备查询此身份证号信息的条件")
public class CuCheckState {
    @ApiModelProperty(name = "本人id",required = true)
    private Integer cuId;
    @ApiModelProperty(name = "需要查找人的身份证号码",required = true)
    private String uCard;

    public CuCheckState(Integer cuId, String uCard) {
        this.cuId = cuId;
        this.uCard = uCard;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard;
    }
}
