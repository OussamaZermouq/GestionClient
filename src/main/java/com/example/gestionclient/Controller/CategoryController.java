package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Category;
import com.example.gestionclient.Service.CategoryService;
import com.example.gestionclient.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor


public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.accepted().build();
    }
    public ResponseEntity<List<Category>> findAllCategory ()
    {return ResponseEntity.ok(categoryService.findAll());}

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String > deletCategory(@PathVariable Integer id )throws Exception{
        categoryService.remove(id);
        return ResponseEntity.ok("Category deleted");

    }
    @PutMapping("/modifyCategory/{id}")
    public ResponseEntity<Category> modiferCategory(
            @RequestBody Category category,
            @PathVariable Integer id) throws Exception{
        return categoryService.modify(category,id);
    }




}
