package com.brahimcodester.repository;

import com.brahimcodester.entities.Employee;
import com.brahimcodester.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*
* @author Ibrahima DIALLO
* @version 1.0
* @since 2024-01-07
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByGender(Gender gender);
}
