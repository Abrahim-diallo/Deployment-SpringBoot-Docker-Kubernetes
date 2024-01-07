package com.brahimcodester.exceptions;

/*
*
* @author Ibrahima DIALLO
* @version 1.0
* @since 2024-01-07
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}