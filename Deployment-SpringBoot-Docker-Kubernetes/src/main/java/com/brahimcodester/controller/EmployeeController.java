package com.brahimcodester.controller;

import com.brahimcodester.Dto.EmployeeDTO;
import com.brahimcodester.entities.Gender;
import com.brahimcodester.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/*
 * @author Ibrahima DIALLO
 * @version 1.0
 * @since 2024-01-07
 */

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constants for response messages
    private static final String SUCCESS_INSERT = "Employé inséré avec succès";
    private static final String SUCCESS_UPDATE = "Employé mis à jour avec succès";
    private static final String SUCCESS_DELETE = "Employé supprimée avec succès";
    private static final String SUCCESS_FOUND = "Employé trouvée avec succès";
    private static final String SUCCESS_FOUND_ALL = "Toutes les Employés trouvées";
    private static final String ERROR_NOT_FOUND = "Employé non trouvée";
    private static final String ERROR_REQUEST = "Erreur de requête";
    private static final String ERROR_SERVER = "Erreur interne du serveur";

    @PostMapping
    @Operation(summary = "Create a new employee", description = "Inserts a new employee into the system.")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(SUCCESS_INSERT, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID", description = "Retrieves an employee by their unique identifier.")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    @Operation(summary = "Get all employees", description = "Retrieves a list of all employees.")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/gender/{gender}")
    @Operation(summary = "Get employees by gender", description = "Retrieves employees based on their gender.")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByGender(@PathVariable Gender gender) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByGender(gender);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update employee", description = "Updates the details of an existing employee.")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeById(id, employeeDTO);
        return ResponseEntity.ok(SUCCESS_UPDATE);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee", description = "Deletes employee from the system.")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(SUCCESS_DELETE, HttpStatus.NO_CONTENT);
    }
}
