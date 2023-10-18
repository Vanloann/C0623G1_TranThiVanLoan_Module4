package com.example.email.service;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService{
    @Autowired
    private IEmailRepo emailRepo;

    @Override
    public Email showEmail() {
        return emailRepo.showEmail();
    }

    @Override
    public Email findById(int id) {
        return emailRepo.findById(id);
    }

    @Override
    public void update(int id, Email email) {
        emailRepo.update(id, email);
    }
}
