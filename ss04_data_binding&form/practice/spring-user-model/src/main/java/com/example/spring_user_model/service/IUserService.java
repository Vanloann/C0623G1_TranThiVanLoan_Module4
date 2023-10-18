package com.example.spring_user_model.service;

import com.example.spring_user_model.model.Login;
import com.example.spring_user_model.model.User;

public interface IUserService {
    User checkLogin(Login login);
}


