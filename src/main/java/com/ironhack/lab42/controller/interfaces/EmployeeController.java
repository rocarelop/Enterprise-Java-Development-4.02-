package com.ironhack.lab42.controller.interfaces;


import com.ironhack.lab42.enums.Status;
import com.ironhack.lab42.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeController {

    List<Employee> findAll();
    List<Employee> findByStatus (Status status);
    List<Employee> findByDepartment (String department);
}
