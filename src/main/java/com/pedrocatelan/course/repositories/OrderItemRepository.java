package com.pedrocatelan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocatelan.course.entities.OrderItem;
import com.pedrocatelan.course.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
