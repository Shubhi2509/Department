package com.SpringBootMVC.Homework.Department.dto;

import com.SpringBootMVC.Homework.Department.validationAnnotation.PrimeNumberCheckAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class DepartmentDto {
    private int id;
    @NotEmpty(message = "Title can not be blank")
    private String title;

    @AssertTrue(message = "isActive should be true")
    private boolean isActive;

    private Date createdAt;

    @Min(value = 1, message = "No. of employees can not be less than 1")
    @Max(value = 20, message = "No. of employees can not be more than 20")
    @NotNull(message = "No. of employees can not be null")
    @PrimeNumberCheckAnnotation(message = "No. of Employees should be a prime number")
    @JsonProperty("noOfEmployees")
    private int noOfEmployees;

}
