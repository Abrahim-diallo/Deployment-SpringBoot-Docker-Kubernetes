package com.brahimcodester.controller;

import com.brahimcodester.exceptions.EmployeeNotFoundException;
import com.brahimcodester.exceptions.EmptyListException;
import com.brahimcodester.exceptions.GenderNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description de la classe.
 *
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity EmployeNotFoundExceptionHandler(EmployeeNotFoundException exception) {

        String message;
        message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity EmptyListExceptionHandler(EmptyListException exception) {

        String message;
        message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenderNotFound.class)
    public ResponseEntity EmployeeGenderNotFoundHandler(GenderNotFound exception) {

        String message;
        message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
