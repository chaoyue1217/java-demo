package com.spring.rest;

import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.CategoryEntity;
import com.spring.service.CategoryService;

@RestController
@RequestMapping("/category")
public class Category {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	@ResponseBody
	public List<CategoryEntity> getAll(){
		try {
			return categoryService.CategoryGetAll();
		} catch (IOException e) {
			
		}
		return null;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public CategoryEntity getCategory(@PathVariable("id") int id){
		try {
			return categoryService.CategoryGet(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@PutMapping
	public int updateCategory(@RequestBody CategoryEntity category){
		try {
			return categoryService.CategoryUpdate(category);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@DeleteMapping("/{id}")
	public int deleteCategory(@PathVariable("id") int id){
		try {
			return categoryService.CategoryDelete(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
}
