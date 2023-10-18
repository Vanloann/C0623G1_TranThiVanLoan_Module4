package com.example.spring_user_model.repository;

import com.example.spring_user_model.model.Login;
import com.example.spring_user_model.model.User;

public interface IUserRepo {
    User checkLogin(Login login);
}
