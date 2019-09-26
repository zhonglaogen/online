package com.zlx.resume.exception;

import com.zlx.resume.result.CodeMsg;

/**
 * <p>
 * 自定义全局异常类
 */
public class GlobalException extends RuntimeException {


    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
