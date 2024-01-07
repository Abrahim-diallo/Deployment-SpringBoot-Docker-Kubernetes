package com.brahimcodester.exceptions;

/**
 * Description
 *
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){
        super("No employee found with the specified ID");
    }
}
