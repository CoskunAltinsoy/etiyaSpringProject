package com.etiya.northwind.business.conretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;

@Service
public class SupplierManager implements SupplierService{

	private SupplierRepository supplierRepository;
	private  ModelMapperService modelMapperService;
	
	public SupplierManager(SupplierRepository supplierRepository,  ModelMapperService modelMapperService) {
		this.supplierRepository = supplierRepository;
		this.modelMapperService =  modelMapperService;
	}

	@Override
	public List<SupplierListResponse> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = result.stream().map(supplier -> this.modelMapperService.forResponse()
				                              .map(supplier, SupplierListResponse.class)).collect(Collectors.toList());
		
		return response;
	}

}
