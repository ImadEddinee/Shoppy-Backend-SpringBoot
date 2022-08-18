package com.ensas.shoppybackendspring.exceptions.exception;

import com.ensas.shoppybackendspring.exceptions.CategoryNotFoundException;
import com.ensas.shoppybackendspring.exceptions.CountryNotFoundException;
import com.ensas.shoppybackendspring.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleProductException(ProductNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                e.getMessage(),new Date(),badRequest
        );
        return new ResponseEntity<>(exceptionResponse, badRequest);
    }

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryException(CategoryNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                e.getMessage(),new Date(),badRequest
        );
        return new ResponseEntity<>(exceptionResponse, badRequest);
    }

    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryException(CountryNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                e.getMessage(),new Date(),badRequest
        );
        return new ResponseEntity<>(exceptionResponse, badRequest);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getFieldError().getDefaultMessage(), new Date(),httpStatus
        );
        return new ResponseEntity<>(exceptionResponse,httpStatus);
    }
}
