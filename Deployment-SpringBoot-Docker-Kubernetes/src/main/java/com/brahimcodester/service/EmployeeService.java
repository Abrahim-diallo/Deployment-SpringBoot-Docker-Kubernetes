package com.brahimcodester.service;

import com.brahimcodester.Dto.EmployeeDTO;
import com.brahimcodester.entities.Employee;
import com.brahimcodester.entities.Gender;

import java.util.List;

/*
*
* @author Ibrahima DIALLO
* @version 1.0
* @since 2024-01-07
 */
public interface EmployeeService {
    //POST
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    //GET
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByGender(Gender gender);

    //PUT
    EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO);

    //DELETE
    void deleteEmployeeById(Long id);

    //PATCH
   // EmployeeDTO patchEmployeeById(Long id, EmployeeDTO empemployeeDTO);

}
