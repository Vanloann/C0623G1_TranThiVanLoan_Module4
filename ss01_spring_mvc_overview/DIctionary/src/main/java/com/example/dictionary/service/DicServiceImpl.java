package com.example.dictionary.service;

import com.example.dictionary.repository.IDicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicServiceImpl implements IDicService{

    @Autowired
    private IDicRepo dicRepo;

    @Override
    public String translate(String word) {
        return dicRepo.translate(word);
    }
}
