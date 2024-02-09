package com.diego.northwindproyect.proyect.Controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.diego.northwindproyect.proyect.models.Shippers;
import com.diego.northwindproyect.proyect.models.Employees;
import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.ProductRepository;
import com.diego.northwindproyect.proyect.repositories.ShippersRepository;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model ) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/products";
    }


    // @Autowired
    // private ProductRepository productRepository2;

    // @GetMapping("/prueba")
    // //http://localhost:8080/prueba?id=2
    // public Products show(@RequestParam Long id){
    //     Optional<Products> productOptional = productRepository2.findById(id);
    //     if (productOptional.isPresent()) {
    //         return productOptional.get();
    //     } else {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    //     }
    // }


    // //ID:"2", {"productId":2,"productName":"Chang","supplierId":1,"quantityPerUnit":"24 - 12 oz bottles","unitPrice":19.0,"unitsInStock":17,"unitsOnOrder":40,"reorderLevel":25,"discontinued":true,"category":{"categoryId":1,"categoryName":"Beverages","description":"Soft drinks, coffees, teas, beers, and ales","picture":"\\x"}}


    // @Autowired
    // private ProductRepository productRepository;
    // @PostMapping("/{id}/entrada")
    // //Tests using params
    // public ResponseEntity<Products> addProduct(@PathVariable Long id, @RequestParam int quantity){
    //     Boolean discontinued;
    //     //http://localhost:8080/2/entrada?quantity=5
    //     Optional<Products> productFind = productRepository.findById(id);

    //     if (productFind.isPresent()) {
    //         Products product = productFind.get();

    //         //bd discontinued is a integer, not a boolean!!!!
    //         if(product.isDiscontinued() == 1){
    //             discontinued = false;
    //         }else{
    //             discontinued = true;
    //         }

    //         if (!discontinued) {
    //             return ResponseEntity.badRequest().body(product);
    //         }

    //         product.setUnitsInStock(product.getUnitsInStock() + quantity);  
    //         productRepository.save(product);
    //         return ResponseEntity.ok(product);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     }
    // }
}
