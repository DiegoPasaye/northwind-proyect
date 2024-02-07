package com.diego.northwindproyect.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.northwindproyect.proyect.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByUnitsInStock(Integer units_in_stock);
}
