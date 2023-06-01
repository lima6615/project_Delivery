package com.projecao.projeto.delivery.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_endereco")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String state;
    
    @Column(name = "bairro")
    private String district;
    
    @Column(name = "cidade")
    private String city;
    
    @Column(name = "rua")
    private String road;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private User user;
    
    public Address(){}

    public Address(Long id, String state, String district, String city, String road, User user) {
        this.id = id;
        this.state = state;
        this.district = district;
        this.city = city;
        this.road = road;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }
    
    public User getUser() {
		return user;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
