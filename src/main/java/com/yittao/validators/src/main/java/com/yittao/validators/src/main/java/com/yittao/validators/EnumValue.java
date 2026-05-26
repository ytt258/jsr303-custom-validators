package com.yittao.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 枚举值校验注解
 * 校验整型值是否匹配枚举类中指定方法的返回值
 *
 * <pre>
 * 用法示例：
 * {@code
 * public enum Status {
 *     PENDING(0), SUCCESS(1), FAILED(2);
 *     private final int code;
 *     Status(int code) { this.code = code; }
 *     public int getCode() { return code; }
 * }
 *
 * @EnumValue(enumClass = Status.class, enumMethod = "getCode")
 * private Integer status;
 * }
 * </pre>
 *
 * @author yittao
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValueValidator.class)
public @interface EnumValue {

    String message() default "值不在枚举范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举类
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * 枚举取值方法名，默认 getCode
     */
    String enumMethod() default "getCode";
}
