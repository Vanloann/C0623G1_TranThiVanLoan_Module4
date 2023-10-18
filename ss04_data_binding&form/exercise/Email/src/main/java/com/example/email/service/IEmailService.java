package com.example.email.service;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailService {

    Email showEmail();

    Email findById(int id);

    void update(int id, Email email);

}
