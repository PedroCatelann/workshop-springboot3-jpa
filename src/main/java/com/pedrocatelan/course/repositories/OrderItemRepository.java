package com.pedrocatelan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocatelan.course.entities.OrderItem;
import com.pedrocatelan.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM OrderItem oi WHERE oi.order.id = :id")
//    void deleteByCompra(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM OrderItem oi WHERE oi.id.order.id = :id")
    void deleteByCompra(Long id);
}
