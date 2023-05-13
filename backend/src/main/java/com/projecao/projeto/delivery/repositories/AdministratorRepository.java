package com.projecao.projeto.delivery.repositories;

import com.projecao.projeto.delivery.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long > {
}
