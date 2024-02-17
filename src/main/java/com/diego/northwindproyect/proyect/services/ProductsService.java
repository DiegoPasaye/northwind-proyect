package com.diego.northwindproyect.proyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.ProductRepository;

import org.springframework.ui.Model;

@Service
public class ProductsService {
    @Autowired
    private ProductRepository productRepository;


    public Products getProductById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    //GET TABLES
    public List<Products> listProducts(){
        return productRepository.findAll();
    }


    //Deleteee
    public void deleteProducts(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    //SAVE-UPDATE
    public void saveProduct(Products products) {
        productRepository.save(products);
    }
}
