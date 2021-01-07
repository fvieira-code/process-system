package com.justica.processo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = CNPJContraintValidator.class)
public @interface CNPJ {
    String message() default "validation.cnpj.invalid.message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
