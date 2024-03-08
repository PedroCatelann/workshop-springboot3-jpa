package com.pedrocatelan.course.resources;

import java.net.URI;
import java.util.List;

import com.pedrocatelan.course.entities.OrderItem;
import com.pedrocatelan.course.entities.Payment;
import com.pedrocatelan.course.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pedrocatelan.course.entities.Order;
import com.pedrocatelan.course.services.OrderService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Order> insert (@RequestBody Order order) {

		order = service.insert(order);


		for (OrderItem item : order.getItems()) {
			OrderItem oi = new OrderItem(item.getOrder(), item.getProduct(), item.getQuantity(), item.getPrice());

			service.insertOrderItem(oi);
		}


		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();


		return ResponseEntity.created(uri).body(order);
	}

	@PostMapping(value = "insertPayment/{id}")
	public ResponseEntity<Order> insertPayment(@PathVariable Long id, @RequestBody Payment payment) {

		Order obj = service.updateOrderPayment(id, payment);

		return ResponseEntity.ok().body(obj);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj) {
		service.deleteByCompra(id);
		Order order = service.update(id, obj);

		for (OrderItem item : obj.getItems()) {
			OrderItem oi = new OrderItem(order, item.getProduct(), item.getQuantity(), item.getPrice());
			service.insertOrderItem(oi);
		}

		return ResponseEntity.ok().body(obj);
	}

	
} 
