package com.yittao.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 日期格式校验注解
 * 校验字符串是否可以按指定格式解析为日期
 *
 * <pre>
 * 用法示例：
 * {@code
 * @DateFormat(pattern = "yyyy-MM-dd", message = "日期格式错误")
 * private String paymentDate;
 * }
 * </pre>
 *
 * @author yittao
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateFormatValidator.class)
public @interface DateFormat {

    String message() default "日期格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 日期格式，默认 yyyy-MM-dd
     */
    String pattern() default "yyyy-MM-dd";
}
