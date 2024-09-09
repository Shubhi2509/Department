package com.SpringBootMVC.Homework.Department.validationAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.stream.IntStream;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberCheckAnnotation, Integer> {

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return IntStream.range(2, (i / 2) + 1).noneMatch(num -> num % 2 == 0);
    }
}
