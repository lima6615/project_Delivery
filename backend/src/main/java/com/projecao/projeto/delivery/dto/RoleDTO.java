package com.projecao.projeto.delivery.dto;

import java.io.Serializable;

import com.projecao.projeto.delivery.entities.Role;

public class RoleDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String authorith;
	
	public RoleDTO() {
	}
	
	public RoleDTO(Role entity) {
		id = entity.getId();
		authorith = entity.getAuthorith();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorith() {
		return authorith;
	}

	public void setAuthorith(String authorith) {
		this.authorith = authorith;
	}
}
