package com.zlx.resume.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "expirences")
public class Expirences {
    @Field("ucard")
    private String uCard;
    @Field("expir")
    private List<Expirence> expirences;


    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard;
    }

    public List<Expirence> getExpirences() {
        return expirences;
    }

    public void setExpirences(List<Expirence> expirences) {
        this.expirences = expirences;
    }
}
