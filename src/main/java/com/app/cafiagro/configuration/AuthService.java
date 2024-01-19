package com.app.cafiagro.configuration;


import com.app.cafiagro.dto.SignupDTO;
import com.app.cafiagro.dto.UserDTO;


public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
