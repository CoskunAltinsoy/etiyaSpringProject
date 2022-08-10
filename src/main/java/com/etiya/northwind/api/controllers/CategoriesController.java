package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;




@RestController
@RequestMapping("/api/categories/")
public class CategoriesController {
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("add")
	public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
		this.categoryService.add(createCategoryRequest);
	}
	
	@DeleteMapping("delete")
	public void delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest){
		this.categoryService.delete(deleteCategoryRequest);
	}
	
	@PutMapping("update")
	public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
		this.categoryService.update(updateCategoryRequest);
	}
	
	
	@GetMapping("getbyid")
	public CategoryGetResponse getbById(@RequestParam int id){
		return this.categoryService.getById(id);
	}
	
	@GetMapping("getall")
	public List<CategoryListResponse> getAll(){
		return this.categoryService.getAll();
	}
}
