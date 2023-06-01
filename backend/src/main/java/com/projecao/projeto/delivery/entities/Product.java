package com.projecao.projeto.delivery.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String name;
	
	@Column(name = "descricao", columnDefinition = "text", nullable = false)
	private String description;
	
	@Column(name = "imagem")
	private String figure;
	
	@Column(name = "preco", nullable = false)
	private Double price;

	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private Set<Category> categories = new HashSet<>();

	
	public Product() {
	}

	public Product(Long id, String name, String description, Double price, String figure) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.figure = figure;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product produto = (Product) o;
		return id.equals(produto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
