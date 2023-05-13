package com.projecao.projeto.delivery.resources;

import com.projecao.projeto.delivery.dto.CategoryDTO;
import com.projecao.projeto.delivery.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    /*@GetMapping
    public ResponseEntity<Page<CategoryDTO>> finAll(Pageable pageable){
        Page<CategoryDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok().body(dto);
    }*/

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> finAll(){
        List<CategoryDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody  CategoryDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable  Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
