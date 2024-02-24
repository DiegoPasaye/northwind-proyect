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

import com.diego.northwindproyect.proyect.models.Categories;
import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.CategoriesRepository;
import com.diego.northwindproyect.proyect.repositories.ProductRepository;
import com.diego.northwindproyect.proyect.services.CategoriesService;
import com.diego.northwindproyect.proyect.services.ProductsService;

@Controller
public class CategoriesController {
    
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesService categoriesService;


    //TABLEEEE
    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Categories> categories = categoriesService.listCategories();
        model.addAttribute("categories", categories);
        return "categories/categories";
    }

    //DeleteMapping not support, i tried
    @PostMapping("/categories/{id}")
    public String deleteCategories(@PathVariable Long id){
        categoriesService.deleteCategories(id);
        return "redirect:/categories";
    }



    //EDIT
    @GetMapping("/categories/{id}/edit")
    public String editCategories(@PathVariable("id") Long id, Model model) {
        Categories categories = categoriesRepository.findById(id).orElse(null);
        model.addAttribute("categories", categories);
        return "categories/edit";
    }
    
    //ID GENERATED IS RARE IN URL, ISN´T PATH ID
    @PostMapping("/categories/{id}/edit")
    public String updateCategories(@PathVariable("id") Long id, @ModelAttribute Categories categories) {
        Categories categories2 = categoriesRepository.findById(id).orElse(null);
        if (categories2 != null) {
            BeanUtils.copyProperties(categories, categories2, "id");

            
            categoriesRepository.save(categories2);
        }
        return "redirect:/categories";
    }



    //CREATEE

    @GetMapping("/categories/create")
    public String newCategories(Model model) {
        model.addAttribute("categories", new Categories());
        return "categories/create";
    }

    @PostMapping("/categories/new")
    public String createCategories(@ModelAttribute Categories categories) {
        categoriesRepository.save(categories);
        return "redirect:/categories";
    }

}
