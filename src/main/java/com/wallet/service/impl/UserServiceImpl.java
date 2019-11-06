package com.wallet.service.impl;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired // para injetar as funcionalidades do repositório
    UserRepository repository;

    @Override
    public User save(User a) {
        return repository.save(a);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return repository.findByEmailEquals(email);
    }
}
