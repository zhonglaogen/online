package com.zlx.resume.redis;

public class CompanyKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天

    private CompanyKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


    /**
     * 需要缓存的字段
     */
    //公司登录信息的token
    public static CompanyKey token = new CompanyKey(TOKEN_EXPIRE,"cutoken");
    //公司登录信息的session
    public static CompanyKey getById = new CompanyKey(0, "cuid");
    //公司查询简历的验证码
    public static CompanyKey getCode = new CompanyKey(60*10, "cucode");
    //公司验证码正确生成的验证正确信息
    public static CompanyKey getUserToken = new CompanyKey(60*60*24, "cufindtoken");
}
