package com.pedrocatelan.course.services;

import java.util.List;
import java.util.Optional;

import com.pedrocatelan.course.services.exceptions.DatabaseException;
import com.pedrocatelan.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedrocatelan.course.entities.Category;
import com.pedrocatelan.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}

	public Category insert(Category category) {
		return repository.save(category);
	}

	public Category update(Long id, Category category) {
		try {
			Category entity = repository.getReferenceById(id);
			updateData(entity, category);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		}
	}

	private void updateData(Category entity, Category category) {
		entity.setName(category.getName());
	}

	public void delete(Long id) {
		try {
			if(repository.existsById(id)) repository.deleteById(id);
			else throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
