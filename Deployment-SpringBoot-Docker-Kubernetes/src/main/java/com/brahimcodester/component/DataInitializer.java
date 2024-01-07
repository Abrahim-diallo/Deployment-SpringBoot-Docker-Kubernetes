
package com.brahimcodester.component;

import com.brahimcodester.Dto.EmployeeDTO;
import com.brahimcodester.entities.Gender;
import com.brahimcodester.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
/*
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */

@Component
public class DataInitializer {
    @Autowired
    private EmployeeService employeeService;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 50; i++) {
            EmployeeDTO employee = generateRandomEmployee();
            employeeService.saveEmployee(employee);
        }
    }
    private EmployeeDTO generateRandomEmployee() {
        Random random = new Random();
        String[] firstNames = {"Aminata", "Fatou", "Mamadou", "Cheikh", "Ndeye", "Oumar"};
        String[] lastNames = {"Diop", "Ndiaye", "Fall", "Sow", "Gueye", "Faye"};
        EmployeeDTO employee = new EmployeeDTO();
        employee.setFirstName(firstNames[random.nextInt(firstNames.length)]);
        employee.setLastName(lastNames[random.nextInt(lastNames.length)]);
        employee.setEmail(employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase() + "@example.com");
        employee.setGender(Gender.values()[random.nextInt(Gender.values().length)]);
        employee.setAge(20 + random.nextInt(40));
        employee.setCellphone("77" + (1000000 + random.nextInt(9000000)));
        employee.setDni(String.valueOf(10000000 + random.nextInt(90000000)));
        return employee;
    }
}