package com.example.email.repository;

import com.example.email.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepoImpl implements IEmailRepo{
    private static List<Email> emailList;
    
    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "Chinese", 25, false, "Thor"));
//        emailList.add(new Email(2, "English", 15, true, "Flo"));
    }

    @Override
    public Email showEmail() {
        return new Email();
    }

    @Override
    public Email findById(int id) {
//        Email email = null;
//        for (Email emails : emailList) {
//            if (emails.getId() == id) {
//                String languages = emails.getLanguages();
//                String signature = emails.getSignature();
//                int page = emails.getPageSize();
//                boolean filter = emails.isSpamsFilter();
//                email = new Email(id, languages, page, filter, signature);
//            }
//        }
//        return email;
        return emailList.get(id);
    }

    @Override
    public void update(int id, Email email) {
        int index = emailList.indexOf(findById(id));
        emailList.set(index, email);
    }
}
