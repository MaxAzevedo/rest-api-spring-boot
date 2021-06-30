package com.br.projetoestudo.api.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static com.br.projetoestudo.api.services.UserAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.projetoestudo.api.entities.User;
import com.br.projetoestudo.api.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	public UserRepository userRepository;

	public UserService userService;

	@BeforeEach
	void setUp() {
		userService = new UserService(userRepository);
	}

	@Test
	public void usuarioSalvoTemDataCriacaoTest() {
		User user = new User("Max Azevêdo");
		when(userRepository.save(any(User.class))).then(returnsFirstArg());
		User userSaved = userService.save(user);
		assertThat(userSaved).hasDataCriacao();
	}
}
