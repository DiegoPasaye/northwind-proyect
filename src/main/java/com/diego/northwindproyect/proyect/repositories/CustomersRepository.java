package com.diego.northwindproyect.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.northwindproyect.proyect.models.Customers;

public interface CustomersRepository extends JpaRepository<Customers,Long>{

}
