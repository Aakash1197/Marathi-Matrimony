package com.matrimonyproject.matrimony.customEnum.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValueValidator implements ConstraintValidator<ValidEnum, Object> {

    private Set<String> acceptedValues;
    private boolean ignoreCase;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        ignoreCase = constraintAnnotation.ignoreCase();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

        acceptedValues = Stream.of(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }



    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value instanceof String strVal) {
            return isValueValid(strVal);
        }

        if (value instanceof Enum<?> enumVal) {
            return isValueValid(enumVal.name());
        }

        if (value instanceof Collection<?> collection) {
            return collection.stream().allMatch(this::isSingleValueValid);
        }

        return false; // unsupported type
    }

    private boolean isSingleValueValid(Object obj) {
        if (obj == null) return true;
        if (obj instanceof String str) return isValueValid(str);
        if (obj instanceof Enum<?> en) return isValueValid(en.name());
        return false;
    }

    private boolean isValueValid(String input) {
        if (ignoreCase) {
            return acceptedValues.stream().anyMatch(val -> val.equalsIgnoreCase(input));
        }
        return acceptedValues.contains(input);
    }
}
