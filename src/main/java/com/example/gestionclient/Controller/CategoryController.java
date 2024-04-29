package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Category;
import com.example.gestionclient.Service.CategoryService;
import com.example.gestionclient.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor


public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @PostMapping("/addCategory")
    public ResponseEntity<String> addCtagory(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.accepted().build();
    }


}
