package com.SpringBootMVC.Homework.Department.validationAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PrimeNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface PrimeNumberCheckAnnotation {
    String message() default "The number should be a prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
