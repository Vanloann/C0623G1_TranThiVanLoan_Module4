package com.example.validateloginform.service;

import com.example.validateloginform.model.User;
import com.example.validateloginform.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
