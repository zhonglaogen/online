package com.zlx.resume.vo;

import com.zlx.resume.validator.IsCard;

import javax.validation.constraints.NotNull;

public class FindVo {
    @NotNull
//    @IsCard
    private String idCard;
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
