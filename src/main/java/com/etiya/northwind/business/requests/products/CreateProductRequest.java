package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

	private int productId;
	private String productName;
	@Max(50)
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;
	private int supplierId;
	private int discontinued; 
}
