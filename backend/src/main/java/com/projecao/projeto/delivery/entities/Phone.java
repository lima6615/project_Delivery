package com.projecao.projeto.delivery.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_telefone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipos")
	private PhoneTypes types;
	
	@Column(name = "numero")
	private String number;

	public Phone() {
	}

	public Phone(Long id, PhoneTypes types, String number) {
		this.id = id;
		this.types = types;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneTypes getTypes() {
		return types;
	}

	public void setTypes(PhoneTypes types) {
		this.types = types;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Phone phone = (Phone) o;
		return Objects.equals(id, phone.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
