package com.diego.northwindproyect.proyect.Controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.diego.northwindproyect.proyect.models.Employees;
import com.diego.northwindproyect.proyect.repositories.EmployeesRepository;


@Controller
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;
    @GetMapping("/employees")
    //I CAN´T RESOLVI THIS, WITH OR WITHOUT @MODELATTRIBUTE IT RUN
    public String listEmployees(Model model ) {
        List<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees/index";
    }
}
