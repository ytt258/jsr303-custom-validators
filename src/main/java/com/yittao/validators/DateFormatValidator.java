package com.yittao.validators.constraint;

import com.yittao.validators.DateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * 日期格式校验器
 * 尝试按指定格式解析字符串，解析失败则校验不通过
 *
 * @author yittao
 */
public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private String pattern;

    @Override
    public void initialize(DateFormat annotation) {
        this.pattern = annotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            // null 和空字符串由 @NotBlank 等注解处理，这里放行
            return true;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            sdf.parse(value.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
