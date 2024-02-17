package com.diego.northwindproyect.proyect.Controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.diego.northwindproyect.proyect.models.Employees;
import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.EmployeesRepository;


@Controller
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;
    @GetMapping("/employees")
    //CRUD
    public String listEmployees(Model model ) {
        List<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees/index";
    }


    //DELETE BY POST, DELETEMAPPING ISN´T SUPPORTED
    @PostMapping("/employees/{id}")
    public String deleteEmployees(@PathVariable Long id){
        employeesRepository.deleteById(id);
        return "redirect:/index";
    }
    //ERROR WITH FOREIGN KEY



    //EDIT-UPDATE
    @GetMapping("/employees/{id}/edit")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employees employees = employeesRepository.findById(id).orElse(null);
        model.addAttribute("employees", employees);
        return "employees/edit";
        //return "product/products"; 
    }
    
    @PostMapping("/employees/{id}/edit")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employees employees) {
        Employees existingProduct = employeesRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            BeanUtils.copyProperties(employees, existingProduct, "id");
            employeesRepository.save(existingProduct);
        }
        return "redirect:/products";
    }



    //CREATE
    @GetMapping("/employees/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employees", new Employees());
        return "employees/create";
    }

    //POST NEW PRODUCT
    //ERROR: IN CREATE HTML, IF I TRY TO ADD THE TH:FIELD TO DISCONTINUED = ERROR
    @PostMapping("/employees/new")
    public String createEmployee(@ModelAttribute("employees") Employees employees) {
        employeesRepository.save(employees);
        return "redirect:/index";
    }
}
