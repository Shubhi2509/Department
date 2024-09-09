package com.SpringBootMVC.Homework.Department.util;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    @CreationTimestamp
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
