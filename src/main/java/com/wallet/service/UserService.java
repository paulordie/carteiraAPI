package com.wallet.service;

import com.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User a); //metodo testado pelo mockito em UserRepositoryTest

    Optional<User> findByEmail(String email);

}
