package com.app.service;

import com.app.exceptions.UsernameAlreadyExistingException;
import com.app.model.User;

public interface UserService {

    void save(User user) throws UsernameAlreadyExistingException;

    User findByUsername(String username);

    User findByEmail(String email);
}
