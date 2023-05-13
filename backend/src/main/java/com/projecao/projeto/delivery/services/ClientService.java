package com.projecao.projeto.delivery.services;


import com.projecao.projeto.delivery.dto.ClientDTO;
import com.projecao.projeto.delivery.entities.Client;
import com.projecao.projeto.delivery.repositories.ClientRepository;
import com.projecao.projeto.delivery.services.exception.DatabaseException;
import com.projecao.projeto.delivery.services.exception.ResourceExistsException;
import com.projecao.projeto.delivery.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private PasswordEncoder encode;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
     Optional<Client> obj = repository.findById(id);
     Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not Found!"));
     return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        dtoToClient(dto, entity);
        try{
            entity = repository.save(entity);
        }catch(DataIntegrityViolationException e){
            throw new ResourceExistsException("Resource Already Exits");
        }
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        findById(id);
        Client entity = new Client();
        dtoToClient(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(" Resource " + id + " Not Found");
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("Integrity Violation");
        }
    }

    public void dtoToClient(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setPassword(encode.encode(dto.getPassword()));
    }
}
