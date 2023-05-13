package com.projecao.projeto.delivery.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "PRODUTO")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String name;
    @Column(name = "DESCRICAO", columnDefinition = "TEXT" , nullable = false)
    private String description;
    @Column(name = "IMAGEM")
    @JsonIgnore
    private String figure;
    @Column(name = "PRECO" , nullable = false)
    private Double price;

    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY",
    joinColumns = @JoinColumn(name = "ID_PRODUTO"),
    inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA"))
    private Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "CLIENTE_PRODUTO",
        joinColumns = @JoinColumn(name = "ID_PRODUTO"),
        inverseJoinColumns = @JoinColumn(name = "ID_CLIENTE"))
    private List<Client> clients = new ArrayList<>();

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

    public List<Client> getClients() {
        return clients;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product produto = (Product) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
