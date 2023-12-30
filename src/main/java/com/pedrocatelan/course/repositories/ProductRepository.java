package com.pedrocatelan.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocatelan.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
