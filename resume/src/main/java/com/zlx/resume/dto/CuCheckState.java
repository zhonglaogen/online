package com.zlx.resume.dto;

/**
 * 用来存储公司用户的id和验证码和用户身份证号码
 */
public class CuCheckState {
    private Integer cuId;
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
