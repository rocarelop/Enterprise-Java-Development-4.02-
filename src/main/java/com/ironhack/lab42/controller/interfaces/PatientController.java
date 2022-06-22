package com.ironhack.lab42.controller.interfaces;


import com.ironhack.lab42.model.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PatientController {

    List <Patient> findAll();
    Patient findById(int id);

    List<Patient> findByDateOfBirthBetween(Date firstDate, Date secondDate);

    @Query("SELECT p.name, e.department FROM Patient p INNER JOIN Employee e ON p.admittedBy = e.id")
    List<Patient> findByDepartmentAdmittingDoctor();

    @Query("SELECT p.name, e.status FROM Patient p INNER JOIN Employee e ON p.admittedBy = e.id WHERE status='OFF'")
    List<Patient> findByStatusOff();



}
