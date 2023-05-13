package com.projecao.projeto.delivery.dto;

import com.projecao.projeto.delivery.entities.Category;

import java.io.Serializable;

public class CategoryDTO  implements Serializable {

    private Long id;
    private String name;

    public CategoryDTO(){
    }

    public CategoryDTO(Category entity){
        id = entity.getId();
        name = entity.getName();
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
