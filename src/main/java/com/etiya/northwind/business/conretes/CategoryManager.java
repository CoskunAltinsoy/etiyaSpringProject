package com.etiya.northwind.business.conretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.dataAccess.abstracts.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{

	private CategoryRepository categoryRepository;
	
	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryListResponse> getAll() {
		List<Category> result = this.categoryRepository.findAll();
		List<CategoryListResponse> response = new ArrayList<CategoryListResponse>();
		for (Category category : result) {
			CategoryListResponse categoryListResponse = new CategoryListResponse();
			categoryListResponse.setCategoryId(category.getCategoryId());
			categoryListResponse.setCategoryName(category.getCategoryName());
			
			response.add(categoryListResponse);
		}
		return response;
	}

}
