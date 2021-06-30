package com.br.projetoestudo.api.DTO;

import java.util.UUID;

import com.br.projetoestudo.api.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
	
	private UUID id;
	private String name;

	public User toUser() {
		return new User(name);
	}

}
