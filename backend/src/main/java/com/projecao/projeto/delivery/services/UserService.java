package com.projecao.projeto.delivery.services;

import java.util.Optional;

import com.projecao.projeto.delivery.services.exceptions.DatabaseException;
import com.projecao.projeto.delivery.services.exceptions.ResourceEmptyException;
import com.projecao.projeto.delivery.services.exceptions.ResourceExistsException;
import com.projecao.projeto.delivery.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projecao.projeto.delivery.dto.RoleDTO;
import com.projecao.projeto.delivery.dto.UserDTO;
import com.projecao.projeto.delivery.dto.UserInsertDTO;
import com.projecao.projeto.delivery.entities.Role;
import com.projecao.projeto.delivery.entities.User;
import com.projecao.projeto.delivery.repositories.RoleRepository;
import com.projecao.projeto.delivery.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository repositoryRole;

	@Autowired
	private PasswordEncoder passwordEncode;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> Users = repository.findAll(pageable);
		return Users.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not Found!"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		entity.setPassword(passwordEncode.encode(dto.getPassword()));
		dtoToEntity(dto, entity);
		Optional<User> result = repository.findByName(dto.getName());
		try {
			if (!result.isPresent()) {
				entity = repository.save(entity);
			} else if (result.isPresent()) {
				throw new ResourceExistsException("Resource Already Exits");
			}
		} catch (DataIntegrityViolationException e) {
			throw new ResourceEmptyException("Resource Empty!");
		}

		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		findById(id);
		User entity = new User();
		dtoToEntity(dto, entity);
		entity.setId(id);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public void delete(Long id) {
		try {
			Optional<User> obj = repository.findById(id);
			obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + id + " Not found!"));
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}

	public void dtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setGender(dto.getGender());

		entity.getRoles().clear();
		for (RoleDTO rol : dto.getRoles()) {
			Optional<Role> obj = repositoryRole.findById(rol.getId());
			Role role = obj.orElseThrow(() -> new ResourceNotFoundException("Resource " + rol.getId() + " Not found!"));
			entity.getRoles().add(role);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return (UserDetails) user;
	}
}
