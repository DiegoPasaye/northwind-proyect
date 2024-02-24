package com.diego.northwindproyect.proyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.diego.northwindproyect.proyect.models.Categories;
import com.diego.northwindproyect.proyect.models.Products;
import com.diego.northwindproyect.proyect.repositories.CategoriesRepository;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

        public Categories getCategoriesById(long categorieId) {
        return categoriesRepository.findById(categorieId).orElse(null);
    }

    //GET TABLES
    public List<Categories> listCategories(){
        return categoriesRepository.findAll();
    }


    //Deleteee
    public void deleteCategories(@PathVariable Long id){
        categoriesRepository.deleteById(id);
    }

    //SAVE-UPDATE
    public void saveCategories(Categories categories) {
        categoriesRepository.save(categories);
    }
}
