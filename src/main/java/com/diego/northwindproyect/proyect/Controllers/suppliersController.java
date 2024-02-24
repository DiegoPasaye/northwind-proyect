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

import com.diego.northwindproyect.proyect.models.Suppliers;
import com.diego.northwindproyect.proyect.repositories.SuppliersRepository;
import com.diego.northwindproyect.proyect.services.SuppliersService;

@Controller
public class suppliersController {
    @Autowired
    private SuppliersRepository suppliersRepository;
    @Autowired
    private SuppliersService suppliersService;


    //TABLEEEE
    @GetMapping("/suppliers")
    public String listSuppliers(Model model) {
        List<Suppliers> suppliers = suppliersService.listSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers";
    }

    //DeleteMapping not support, i tried
    @PostMapping("/suppliers/{id}")
    public String deleteSuppliers(@PathVariable Long id){
        suppliersService.deleteSuppliers(id);
        return "redirect:/suppliers";
    }



    //EDIT
    @GetMapping("/suppliers/{id}/edit")
    public String editSuppliers(@PathVariable("id") Long id, Model model) {
        Suppliers suppliers = suppliersRepository.findById(id).orElse(null);
        model.addAttribute("suppliers", suppliers);
        return "suppliers/edit";
    }
    
    //ID GENERATED IS RARE IN URL, ISN´T PATH ID
    @PostMapping("/suppliers/{id}/edit")
    public String updateSuppliers(@PathVariable("id") Long id, @ModelAttribute Suppliers suppliers) {
        Suppliers suppliers2 = suppliersRepository.findById(id).orElse(null);
        if (suppliers2 != null) {
            BeanUtils.copyProperties(suppliers, suppliers2, "id");
        
            suppliersRepository.save(suppliers2);
        }
        return "redirect:/suppliers";
    }



    //CREATEE

    @GetMapping("/suppliers/create")
    public String newSuppliers(Model model) {
        model.addAttribute("suppliers", new Suppliers());
        return "suppliers/create";
    }

    @PostMapping("/suppliers/new")
    public String createSuppliers(@ModelAttribute Suppliers suppliers) {
        suppliersRepository.save(suppliers);
        return "redirect:/suppliers";
    }
}
