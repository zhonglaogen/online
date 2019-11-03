package com.zlx.resume.vo;

import com.zlx.resume.validator.IsCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "用于描述验证码发送和接受相关信息")
public class FindVo {
    @NotNull
//    @IsCard
    @ApiModelProperty(name = "需要查找人的身份证号码",required = true)
    private String idCard;
    @ApiModelProperty(name = "验证码内容")
    private String checkCode;

    @Override
    public String toString() {
        return "FindVo{" +
                "idCard='" + idCard + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }


    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
