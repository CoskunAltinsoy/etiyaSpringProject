package com.etiya.northwind.business.conretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailGetResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService{

	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository,  ModelMapperService modelMapperService) {
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateOrderDetailRequest createOrderDetailRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UpdateOrderDetailRequest updateOrderDetailRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDetailGetResponse getById(int orderId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderDetailListResponse> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> response = result.stream().map(orderDetail -> this.modelMapperService.forResponse()
				                                  .map(orderDetail, OrderDetailListResponse.class)).collect(Collectors.toList());          
		return response;
	}
	

}
