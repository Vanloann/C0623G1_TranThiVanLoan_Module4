package com.example.validateloginform.repository;

import com.example.validateloginform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
}
