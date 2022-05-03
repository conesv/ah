package com.cbsbankui.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cbsbankui.model.OrderInfo;
import com.cbsbankui.model.Vendor;
import com.cbsbankui.utility.CredentialsUtility;

@Controller
public class OrderController {

	private RestTemplate restTemplate = new RestTemplate();
	HttpSession session;
	
	@RequestMapping("/order")
	public String showOrder(){
		return "order";
	}
	
	@RequestMapping("/add-order")
	public String addOrder(Model model){
		HttpEntity<String> entity = new HttpEntity<>(CredentialsUtility.getHeaders());
		ResponseEntity<List> response = restTemplate.exchange("http://localhost:8210/vendor", HttpMethod.GET, entity, List.class);
		List<Vendor> list = response.getBody();
		model.addAttribute("list", list);
		return "add-order";
	}
	
	@RequestMapping("/process-add-order")
	public String processAddOrder(@RequestParam("orderDetails") String details, @RequestParam("expectedDateOfFulfillment") String date,
			@RequestParam("amount") double amount, @RequestParam("vendorId") Long vendorId, Model model) {
		OrderInfo order = new OrderInfo(details, date, amount);
		restTemplate.postForObject("http://localhost:8210/order/"+vendorId, order, OrderInfo.class);
		model.addAttribute("msg", "Order placed successfully");
		return "add-order";
	}
	
	@RequestMapping("/order-list-pending")
	public String showPendingOrders(Model model) {
		HttpEntity<String> entity = new HttpEntity<>(CredentialsUtility.getHeaders());
		ResponseEntity<List> response = restTemplate.exchange("http://localhost:8210/order/pending", HttpMethod.GET, entity, List.class);
		List<OrderInfo> list = response.getBody();
		model.addAttribute("list", list);
		return "order-list";
	}
	
	@RequestMapping("/order-list-completed")
	public String showCompletedOrders(Model model) {
		HttpEntity<String> entity = new HttpEntity<>(CredentialsUtility.getHeaders());
		ResponseEntity<List> response = restTemplate.exchange("http://localhost:8210/order/completed", HttpMethod.GET, entity, List.class);
		List<OrderInfo> list = response.getBody();
		model.addAttribute("list", list);
		return "order-list";
	}
	
	@RequestMapping("/order-received")
	public String updateOrderStatus(@RequestParam("id") long id, Model model) {
		HttpEntity<String> entity = new HttpEntity<>(CredentialsUtility.getHeaders());
		restTemplate.exchange("http://localhost:8210/order/status/"+id, HttpMethod.PUT, entity, Void.class);
		ResponseEntity<List> response = restTemplate.exchange("http://localhost:8210/order/pending", HttpMethod.GET, entity, List.class);
		List<OrderInfo> list = response.getBody();
		model.addAttribute("list", list);
		return "order-list";
	}
}









