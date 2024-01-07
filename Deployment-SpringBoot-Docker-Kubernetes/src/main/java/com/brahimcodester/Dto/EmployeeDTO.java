package com.brahimcodester.Dto;

import com.brahimcodester.entities.Gender;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String cellphone;
    private Gender gender;
    private String dni;

}