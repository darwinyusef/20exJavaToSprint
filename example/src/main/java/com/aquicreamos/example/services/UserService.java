package com.aquicreamos.example.services;

import com.aquicreamos.example.models.User;
import com.aquicreamos.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}