package com.matrimonyproject.matrimony.customEnum.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)  // Specify the validator class
public @interface ValidEnum {

    String message() default "Invalid value";  // Default error message

    Class<?>[] groups() default {};          // Validation groups

    Class<? extends Payload>[] payload() default {}; // Additional data for the validation

    Class<? extends Enum<?>> enumClass(); // Enum class that is being validated
    boolean ignoreCase() default false;
}
