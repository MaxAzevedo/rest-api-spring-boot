package com.br.projetoestudo.api.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projetoestudo.api.entities.User;
import com.br.projetoestudo.api.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userResRepository) {
		this.userRepository = userResRepository;
	}
	
	public User save(User user) {
		user.setDataCriacao(LocalDate.now());
		return this.userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public User update(Long id, User user) {
		User userFromDB = userRepository.findById(id).get();
		userFromDB.setName(user.getName());
		return userRepository.save(userFromDB);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
