package com.brahimcodester.exceptions;

import com.brahimcodester.entities.Gender;

/**
 * Description de la classe.
 *
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */

public class GenderNotFound extends RuntimeException{

    public GenderNotFound(Gender gender){
        super("No employees found with the " + gender  + " gender ");
    }
}
