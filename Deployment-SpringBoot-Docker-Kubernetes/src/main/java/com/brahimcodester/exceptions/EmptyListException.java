package com.brahimcodester.exceptions;

/**
 * Description de la classe.
 *
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */
public class EmptyListException extends RuntimeException{

    public EmptyListException(){
        super("No employees are loaded in the database");
    }
}
