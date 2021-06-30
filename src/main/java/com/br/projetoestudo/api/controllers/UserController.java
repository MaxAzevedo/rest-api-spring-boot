package com.br.projetoestudo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projetoestudo.api.DTO.UserDTO;
import com.br.projetoestudo.api.entities.User;
import com.br.projetoestudo.api.services.UserService;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public ResponseEntity<List<User>> getAllTodos() {
		return new ResponseEntity<List<User>>(
				(List<User>) userService.findAll(), 
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<User>(
				userService.findById(id), 
				HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public ResponseEntity<User> save(@RequestBody UserDTO dto) {
		User user = userService.save(dto.toUser());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("todo", "/v1/api/user/" + user.getId().toString());
		return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping({"/{id}"})
	public ResponseEntity<User> update(
			@PathVariable("id") long id, @RequestBody UserDTO user) {
		userService.update(id, user.toUser());
		return new ResponseEntity<User>(
				userService.findById(id), 
				HttpStatus.OK);
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseEntity<User> delete(@PathVariable("id") Long id){
		userService.delete(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
