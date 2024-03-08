package com.pedrocatelan.course.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.pedrocatelan.course.entities.OrderItem;
import com.pedrocatelan.course.entities.Payment;
import com.pedrocatelan.course.entities.enums.OrderStatus;
import com.pedrocatelan.course.repositories.OrderItemRepository;
import com.pedrocatelan.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocatelan.course.entities.Order;
import com.pedrocatelan.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<Order> findAll() {
		
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}

	public Order insert (Order order) {
		return repository.save(order);
	}

	public OrderItem insertOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	public Order updateOrderPayment(Long id, Payment payment) {
		try {
			Order entity = repository.getReferenceById(id);
			updateDataPayment(entity, payment);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDataPayment(Order entity, Payment pay) {
		entity.setPayment(new Payment(null, pay.getMoment(), entity));
		entity.setOrderStatus(OrderStatus.PAID);
	}

	public Order update(Long id, Order order) {
		try {
			Order entity = repository.getReferenceById(id);
			return repository.save(entity);


		} catch (EntityNotFoundException exception) {
			throw new ResourceNotFoundException(id);
		}
	}
	public void deleteByCompra(Long id) {
		orderItemRepository.deleteByCompra(id);
	}
	private void updateOrder(Order entity, Order order) {
		entity.setMoment(Instant.now());
	}
}
