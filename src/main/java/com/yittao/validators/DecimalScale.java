package com.yittao.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 金额小数位校验注解
 * 校验 Number 类型字段的小数位数是否在指定范围内
 *
 * <pre>
 * 用法示例：
 * {@code
 * @DecimalScale(min = 0, max = 2, message = "金额小数位数不能超过2位")
 * private BigDecimal amount;
 * }
 * </pre>
 *
 * @author yittao
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DecimalScaleValidator.class)
public @interface DecimalScale {

    String message() default "小数位数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 最小小数位数，默认0
     */
    int min() default 0;

    /**
     * 最大小数位数，默认2
     */
    int max() default 2;
}
