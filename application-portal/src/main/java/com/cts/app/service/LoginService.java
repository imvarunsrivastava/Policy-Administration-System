package com.cts.app.service;

import com.cts.app.dto.AuthenticationResponseDTO;
import com.cts.app.model.LoginModel;

public interface LoginService {

	public AuthenticationResponseDTO login(LoginModel login);
}
