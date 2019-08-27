package com.zlx.resume.redis;

public class CompanyKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天

    private CompanyKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


    /**
     * 需要缓存的字段
     */
    public static CompanyKey token = new CompanyKey(TOKEN_EXPIRE,"cutoken");
    public static CompanyKey getById = new CompanyKey(0, "cuid");
}
