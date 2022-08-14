package com.etiya.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.northwind.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	//List<Product> findByCategory_id (int category_Id);
	Product findByProductName(String name);
}
