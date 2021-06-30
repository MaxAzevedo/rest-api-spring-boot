package com.br.projetoestudo.api.services;

import org.assertj.core.api.AbstractAssert;

import com.br.projetoestudo.api.entities.User;

public class UserAssert extends AbstractAssert<UserAssert, User> {

	public UserAssert(User user) {
		super(user, UserAssert.class);
	}

	public static UserAssert assertThat(User actual) {
		return new UserAssert(actual);
	}

	public UserAssert hasDataCriacao() {
		isNotNull();
		if (actual.getDataCriacao() == null) {
			failWithMessage("O usuário deve ter data de criação, mas a data está null");
		}
		return this;
	}
}
