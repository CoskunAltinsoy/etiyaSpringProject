package com.etiya.northwind.business.conretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.suppliers.SupplierGetResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Product;
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
	public Result add(CreateSupplierRequest createSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest()
				.map(createSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		return new SuccessResult();
		
	}

	@Override
	public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
		this.supplierRepository.deleteById(deleteSupplierRequest.getSupplierId());
		return new SuccessResult();
		
	}

	@Override
	public Result update(UpdateSupplierRequest updateSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest()
				.map(updateSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		return new SuccessResult();
		
	}

	@Override
	public DataResult<SupplierGetResponse>  getById(int id) {
		 Supplier supplier =this.supplierRepository.findById(id).get();
	     SupplierGetResponse supplierResponse = this.modelMapperService.forResponse()
	                .map(supplier, SupplierGetResponse.class);
	     return new SuccessDataResult<SupplierGetResponse>(supplierResponse) ;
	}


	@Override
	public DataResult<List<SupplierListResponse>>  getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> response = result.stream().map(supplier -> this.modelMapperService.forResponse()
				                              .map(supplier, SupplierListResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<SupplierListResponse>>(response);
	}

}
