package com.diego.northwindproyect.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.northwindproyect.proyect.models.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long>{

}
