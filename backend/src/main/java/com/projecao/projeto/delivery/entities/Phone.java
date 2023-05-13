package com.projecao.projeto.delivery.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TELEFONE")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPOS")
    private PhoneTypes types;
    @Column(name = "NUMERO")
    private String number;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;

    public Phone(){}

    public Phone(Long id, PhoneTypes types, String number, Client client) {
        this.id = id;
        this.types = types;
        this.number = number;
        this.client = client;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
