package com.SpringBootMVC.Homework.Department.advices;

import com.SpringBootMVC.Homework.Department.exceptions.ResourceNotFoundException;
import com.SpringBootMVC.Homework.Department.util.ApiError;
import com.SpringBootMVC.Homework.Department.util.ApiResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle resource not found exception response entity.
     *
     * @param resourceNotFoundException the resource not found exception
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(resourceNotFoundException.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    /**
     * Handle internal server error response entity.
     *
     * @param resourceNotFoundException the resource not found exception
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception resourceNotFoundException) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(resourceNotFoundException.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    /**
     * Handle internal server error response entity.
     *
     * @param methodArgumentNotValidException the method argument not valid exception
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Input Validation Failed")
                .subErrors(errors).build();

        return buildErrorResponseEntity(apiError);
    }
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), HttpStatus.NOT_FOUND);
    }

}
