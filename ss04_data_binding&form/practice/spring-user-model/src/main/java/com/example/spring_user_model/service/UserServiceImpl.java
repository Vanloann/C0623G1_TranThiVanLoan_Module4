package com.example.spring_user_model.service;

import com.example.spring_user_model.model.Login;
import com.example.spring_user_model.model.User;
import com.example.spring_user_model.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepo userRepo;

    @Override
    public User checkLogin(Login login) {
        return userRepo.checkLogin(login);
    }
}
