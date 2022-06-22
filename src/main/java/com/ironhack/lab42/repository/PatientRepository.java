package com.ironhack.lab42.repository;

import com.ironhack.lab42.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(Date firstDate, Date secondDate);

    @Query("SELECT p.name, e.department FROM Patient p INNER JOIN Employee e ON p.admittedBy = e.id")
    List<Patient> findByDepartmentAdmittingDoctor();

    @Query("SELECT p.name, e.status FROM Patient p INNER JOIN Employee e ON p.admittedBy = e.id WHERE status='OFF'")
    List<Patient> findByStatusOff();
}
