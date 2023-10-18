package com.example.email.repository;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailRepo {

    Email showEmail();

    Email findById(int id);

    void update(int id, Email email);

}
