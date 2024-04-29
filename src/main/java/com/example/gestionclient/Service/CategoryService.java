package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Category;
import com.example.gestionclient.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private  final CategoryRepository categoryRepository;
    public void save (Category category ){
        var ca = Category.builder()
                .category_id(category.getCategory_id())
                .titre(category.getTitre())
                .description(category.getDescription())
                .produits(category.getProduits())
                .build();
        categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public void remove ( Integer id) throws Exception{
        Category category_remove = categoryRepository.findById(id).orElseThrow(()->new Exception("category doesent exist"));
        if (category_remove != null ){
            categoryRepository.delete(category_remove);
        }

    }

}
