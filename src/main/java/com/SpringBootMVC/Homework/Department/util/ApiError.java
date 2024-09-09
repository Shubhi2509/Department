package com.SpringBootMVC.Homework.Department.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatusCode status;
    private String message;
    private List<String> subErrors;
}
