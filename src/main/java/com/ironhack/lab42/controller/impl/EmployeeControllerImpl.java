package com.ironhack.lab42.controller.impl;

import com.ironhack.lab42.controller.interfaces.EmployeeController;
import com.ironhack.lab42.enums.Status;
import com.ironhack.lab42.model.Employee;
import com.ironhack.lab42.model.Patient;
import com.ironhack.lab42.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
@Autowired
    private EmployeeRepository employeeRepository;

@GetMapping("/employees")
@ResponseStatus(HttpStatus.OK)
public List <Employee> findAll(){
    return employeeRepository.findAll();
}

@GetMapping("/employees/{id}")
public Employee findById(@PathVariable(name = "id") int id) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.get();
    }

@GetMapping("/employees/")
@ResponseStatus(HttpStatus.OK)
public List<Employee> findByStatus(@RequestParam (name= "status") Status status) {

    List <Employee> employeeList = employeeRepository.findByStatus(status);
    return employeeList;

}

@GetMapping("/employees/employees/")
@ResponseStatus(HttpStatus.OK)
public List<Employee> findByDepartment(@RequestParam (name= "department") String department) {
    List <Employee> departmentList = employeeRepository.findByDepartment(department);
        return departmentList;
    }

}
