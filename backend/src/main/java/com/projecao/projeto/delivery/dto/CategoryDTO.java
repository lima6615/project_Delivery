package com.projecao.projeto.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.projecao.projeto.delivery.entities.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo requerido")
	private String name;

	public CategoryDTO() {
	}

	public CategoryDTO(Category entity) {
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
