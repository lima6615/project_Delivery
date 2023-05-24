package com.projecao.projeto.delivery.services;

import com.projecao.projeto.delivery.dto.CategoryDTO;
import com.projecao.projeto.delivery.dto.ProductDTO;
import com.projecao.projeto.delivery.entities.Category;
import com.projecao.projeto.delivery.entities.Product;
import com.projecao.projeto.delivery.repositories.CategoryRepository;
import com.projecao.projeto.delivery.repositories.ProductRepository;
import com.projecao.projeto.delivery.services.exception.DatabaseException;
import com.projecao.projeto.delivery.services.exception.ResourceEmptyException;
import com.projecao.projeto.delivery.services.exception.ResourceExistsException;
import com.projecao.projeto.delivery.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository repositoryCategory;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = repository.findAll(pageable);
        return products.map(x -> new ProductDTO(x));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not Found!"));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        dtoToEntity(dto, entity);
        Optional<Product>result = repository.findByName(dto.getName());
        try {
            if (!result.isPresent()) {
                entity = repository.save(entity);
            } else if(result.isPresent()){
                throw new ResourceExistsException("Resource Already Exits");
            }
        }catch(DataIntegrityViolationException e){
            throw new ResourceEmptyException("Resource Empty!");
        }
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        findById(id);
        Product entity = new Product();
        dtoToEntity(dto, entity);
        entity.setId(id);
        entity = repository.save(entity);
        return new ProductDTO(entity , entity.getCategories());
    }

    public void delete(Long id){
        try {
            Optional<Product> obj = repository.findById(id);
            obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not found!"));
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }
    }

    public void dtoToEntity(ProductDTO dto , Product entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setFigure(dto.getFigure());

        entity.getCategories().clear();
        for(CategoryDTO cat : dto.getCategories()){
            Category category = repositoryCategory.findByName(cat.getName()).get();
            entity.getCategories().add(category);
        }
    }
}
