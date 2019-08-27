package com.zlx.resume.validator;

import com.zlx.resume.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsCardValidator implements ConstraintValidator<IsCard, String> {

    private boolean required = false;

    /**
     * 初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(IsCard constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            return ValidatorUtil.isCard(s);
        } else {
            if (StringUtils.isEmpty(s)) {
                return true;
            } else {
                return ValidatorUtil.isCard(s);
            }
        }
    }
}
