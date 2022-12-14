package com.etiya.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.SupplierGetResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/suppliers/")
public class SuppliersController {
	private SupplierService supplierService;

	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	

	@PostMapping("add")
    public Result add(@RequestBody CreateSupplierRequest createSupplierRequest) {
        return this.supplierService.add(createSupplierRequest);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
        return this.supplierService.delete(deleteSupplierRequest);
    }

    @PutMapping("update")
    public Result update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("getbyid")
    public DataResult<SupplierGetResponse>  getById(@RequestParam int id) {
        return this.supplierService.getById(id);
    }
	
	
	@GetMapping("getall")
	public DataResult<List<SupplierListResponse>>  getAll(){
		return this.supplierService.getAll();
	}
	
}
