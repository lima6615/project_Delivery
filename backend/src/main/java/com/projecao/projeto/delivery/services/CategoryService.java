package com.projecao.projeto.delivery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecao.projeto.delivery.dto.CategoryDTO;
import com.projecao.projeto.delivery.entities.Category;
import com.projecao.projeto.delivery.repositories.CategoryRepository;
import com.projecao.projeto.delivery.services.exceptions.DatabaseException;
import com.projecao.projeto.delivery.services.exceptions.ResourceExistsException;
import com.projecao.projeto.delivery.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	
	 @Transactional(readOnly = true) 
	 public Page<CategoryDTO> findAll(Pageable pageable){ 
		 Page<Category> entity = repository.findAll(pageable);
		 return entity.map(x -> new CategoryDTO(x));
	}
	 

	/*@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> entity = repository.findAll();
		return entity.stream().map(x -> new CategoryDTO(x)).toList();
	}*/

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		Optional<Category> result = repository.findByName(dto.getName());
		if (!result.isPresent()) {
			entity = repository.save(entity);
		} else {
			throw new ResourceExistsException("Resource Already Exists!");
		}
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not Found!"));
		entity.setId(entity.getId());
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	public void delete(Long id) {
		try {
			Optional<Category> result = repository.findById(id);
			result.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not Found!"));
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
}
