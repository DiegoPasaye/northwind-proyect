package com.diego.northwindproyect.proyect.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diego.northwindproyect.proyect.models.Customers;
import com.diego.northwindproyect.proyect.repositories.CustomersRepository;

@Controller
public class CustomersController {

    @Autowired
    CustomersRepository customersRepository;

    @GetMapping("/customers")
    public String listCustomers(Model model){
        List<Customers> customers = customersRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers/customers";
    }
}
