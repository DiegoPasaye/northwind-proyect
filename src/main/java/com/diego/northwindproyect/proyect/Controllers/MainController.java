package com.diego.northwindproyect.proyect.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.services.ProductsService;

@Controller
public class MainController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/index")
    public String listProducts(Model model){
        List<Products> products = productsService.listProducts();
        model.addAttribute("products", products);
        return "main/indexProducts";
    }


    @GetMapping("/register")
    public String register(){
        return"main/register";
    }
    @GetMapping("/login")
    public String login(){
        return"main/login";
    }
}
