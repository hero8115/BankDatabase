package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.CategoryDTO;
import com.example.bankdatabase.entity.Branchs;
import com.example.bankdatabase.entity.Category;
import com.example.bankdatabase.repository.BranchsRepository;
import com.example.bankdatabase.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BranchsRepository branchsRepository;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
    public List<Category> categoryListbyId(@PathVariable Integer id){
        return categoryRepository.findAllById(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String addcategory(@RequestBody CategoryDTO categoryDTO){
        Optional<Branchs> byId = branchsRepository.findById(categoryDTO.getBranchs_id());
        if (byId.isPresent()){
            Category category = new Category();
            category.setName(categoryDTO.getName());
            category.setBranchs(byId.get());
            categoryRepository.save(category);
            return "Categoriya qo'shildi";
        }
        return "Filial topilmadi";
    }

}
