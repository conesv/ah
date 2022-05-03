package com.cbs.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.banking.model.OrderInfo;
import com.cbs.banking.model.Vendor;
import com.cbs.banking.repository.OrderRepository;
import com.cbs.banking.repository.VendorRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private VendorRepository vendorRepository;

	@PostMapping("/order/{vid}")
	public OrderInfo postOrder(@RequestBody OrderInfo order, @PathVariable("vid") long vendorId) {
		Vendor vendor = vendorRepository.getById(vendorId);
		order.setVendor(vendor);
		order.setStatus("PENDING");
		return orderRepository.save(order);
	}

	@GetMapping("/order")
	public List<OrderInfo> getOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/order/pending")
	public List<OrderInfo> getPendingOrders(){
		return orderRepository.fetchOrdersByStatus("PENDING");
	}
	
	@GetMapping("/order/completed")
	public List<OrderInfo> getCompletedOrders(){
		return orderRepository.fetchOrdersByStatus("COMPLETED");
	}
	
	@PutMapping("order/status/{oid}")
	public void changeStatus(@PathVariable("oid") long orderId) {
		orderRepository.changeStatus(orderId, "COMPLETED");
	}
}










