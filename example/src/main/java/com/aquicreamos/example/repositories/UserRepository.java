package com.aquicreamos.example.repositories;

import com.aquicreamos.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}