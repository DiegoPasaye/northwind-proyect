package com.diego.northwindproyect.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.northwindproyect.proyect.models.Shippers;

public interface ShippersRepository extends JpaRepository<Shippers, Long> {
}
