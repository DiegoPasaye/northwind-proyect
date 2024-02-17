package com.diego.northwindproyect.proyect.Controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.diego.northwindproyect.proyect.models.Shippers;
import com.diego.northwindproyect.proyect.models.Employees;
import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.ProductRepository;
import com.diego.northwindproyect.proyect.repositories.ShippersRepository;
import com.diego.northwindproyect.proyect.services.ProductsService;




@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductsService productsService;


    //TABLEEEE
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Products> products = productsService.listProducts();
        model.addAttribute("products", products);
        return "product/products";
    }

    //DeleteMapping not support, i tried
    @PostMapping("/products/{id}")
    public String deleteProducts(@PathVariable Long id){
        productsService.deleteProducts(id);
        return "redirect:/products";
    }



    //EDIT
    @GetMapping("/products/{id}/edit")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Products products = productRepository.findById(id).orElse(null);
        model.addAttribute("products", products);
        return "product/edit";
    }
    
    //ID GENERATED IS RARE IN URL, ISN´T PATH ID
    @PostMapping("/products/{id}/edit")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Products products) {
        Products products2 = productRepository.findById(id).orElse(null);
        if (products2 != null) {
            BeanUtils.copyProperties(products, products2, "id");
            products2.setDiscontinued(0);

            
            productRepository.save(products2);
        }
        return "redirect:/products";
    }



    //CREATEE

    @GetMapping("/products/create")
    public String newProduct(Model model) {
        model.addAttribute("products", new Products());
        return "product/create";
    }

    @PostMapping("/products/new")
    public String createProduct(@ModelAttribute Products products) {
        products.setDiscontinued(0);
        productRepository.save(products);
        return "redirect:/products";
    }










    //POST NEW PRODUCT
    //ERROR: IN CREATE HTML, IF I TRY TO ADD THE TH:FIELD TO DISCONTINUED = ERROR
    // @PostMapping("/products/new")
    // public String saveProduct(@ModelAttribute Product newProduct) {
    //     productService.saveProduct(newProduct);
    //     return "redirect:/products"; // Redirige a la lista de productos
    // }


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
