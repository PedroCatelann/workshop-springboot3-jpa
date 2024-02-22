package com.pedrocatelan.course.services;

import java.util.List;
import java.util.Optional;

import com.pedrocatelan.course.entities.Category;
import com.pedrocatelan.course.entities.User;
import com.pedrocatelan.course.services.exceptions.DatabaseException;
import com.pedrocatelan.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedrocatelan.course.entities.Product;
import com.pedrocatelan.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}

	public Product insert(Product product) {
		return repository.save(product);
	}

	public Product update(Long id, Product product) {
		try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, product);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {

		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
		for (Category cat : obj.getCategories()) {
			entity.getCategories().add(cat);
		}
	}

	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
