package com.zlx.resume.redis;

public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 *2;//默认两天

    /**
     * 防止被外面实例化
     */
    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    //用户登录的token，cookie(通过这个随机数向redis中检验是否为登录状态)
    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");
//    用户登录验证时需要对比的数据
    public static UserKey getById = new UserKey(0, "id");
//    公司查询用户简历时需要缓存的数据（通过身份证号码）
    public static UserKey getByCard = new UserKey(0, "card");

}
