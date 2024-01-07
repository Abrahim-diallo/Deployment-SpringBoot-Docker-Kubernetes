package com.brahimcodester.serviceImpl;

import com.brahimcodester.Dto.EmployeeDTO;
import com.brahimcodester.entities.Employee;
import com.brahimcodester.entities.Gender;
import com.brahimcodester.errorHandler.EmptyListException;
import com.brahimcodester.errorHandler.EmployeeNotFoundException;
import com.brahimcodester.errorHandler.GenderNotFound;
import com.brahimcodester.mapper.EmployeeMapper;
import com.brahimcodester.repository.EmployeeRepository;
import com.brahimcodester.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
/*
*
* @author Ibrahima DIALLO
* @version 1.0
* @since 2024-01-07
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }
    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new EmptyListException();
        }
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployeesByGender(Gender gender) {
        List<Employee> employees = employeeRepository.findAllByGender(gender);
        if (employees.isEmpty()) {
            throw new GenderNotFound(gender);
        }
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        // Update fields
        updateEmployeeFields(employeeToUpdate, employeeDTO);

        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
        return employeeMapper.employeeToEmployeeDTO(updatedEmployee);
    }

    private void updateEmployeeFields(Employee employee, EmployeeDTO employeeDTO) {
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setGender(employeeDTO.getGender());
        employee.setAge(employeeDTO.getAge());
        employee.setCellphone(employeeDTO.getCellphone());
        employee.setDni(employeeDTO.getDni());
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        log.info("Employee with id {} deleted", id);
    }

}
