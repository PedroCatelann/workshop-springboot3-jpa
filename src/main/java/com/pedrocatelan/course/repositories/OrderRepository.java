package com.pedrocatelan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocatelan.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
