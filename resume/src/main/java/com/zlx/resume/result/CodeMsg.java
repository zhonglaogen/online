package com.zlx.resume.result;

public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    public static CodeMsg PRIMARY_ERROR = new CodeMsg(500216, "主键冲突");

    //查询用户经历模块 5003XX
    public static CodeMsg CARD_NOT_EXIST = new CodeMsg(500314, "此身份证号用户信息不存在");
    public static CodeMsg COED_IS_EXIST = new CodeMsg(500315, "查询验证码已经发送,三分钟内有效");
    public static CodeMsg COED_IS_WRONG = new CodeMsg(500316, "验证码错误");
    public static CodeMsg USER_NOT_CHECK = new CodeMsg(500317, "未验证的查询");
    public static CodeMsg USER_NOT_RESIT=new CodeMsg(500318,"账号未关联公司");


    //添加关联公司模块 5004XX
    public static CodeMsg COMPANY_IS_EXIST = new CodeMsg(500400, "关联公司已经存在");
    public static CodeMsg APPLY_IS_COMMIT = new CodeMsg(500400, "已经提交申请");

    //秒杀模块 5005XX


    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
