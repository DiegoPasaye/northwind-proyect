package com.diego.northwindproyect.proyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.models.Suppliers;
import com.diego.northwindproyect.proyect.repositories.SuppliersRepository;

@Service
public class SuppliersService {
    @Autowired
    private SuppliersRepository suppliersRepository;


    public Suppliers getSuppliersById(long suppliersId) {
        return suppliersRepository.findById(suppliersId).orElse(null);
    }

    //GET TABLES
    public List<Suppliers> listSuppliers(){
        return suppliersRepository.findAll();
    }


    //Deleteee
    public void deleteSuppliers(@PathVariable Long id){
        suppliersRepository.deleteById(id);
    }

    //SAVE-UPDATE
    public void saveSupplierst(Suppliers suppliers) {
        suppliersRepository.save(suppliers);
    }
}
