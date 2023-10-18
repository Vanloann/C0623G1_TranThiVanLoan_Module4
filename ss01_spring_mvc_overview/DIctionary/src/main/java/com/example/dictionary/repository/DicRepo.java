package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DicRepo implements IDicRepo {
    private static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("persevere", "Kiên trì");
        dictionary.put("ice age", "Kỷ Băng Hà");
        dictionary.put("serene", "yên bình");
        dictionary.put("stockpile", "dự trữ");
    }

    @Override
    public String translate(String word) {
//        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
//            if (word.equals(entry.getKey())) {
//                String result = "Source word: " + entry.getKey() + "</br>" + "Target word: " + entry.getValue();
//                return result;
//            }
//        }
        String result = "Source word: " + word + "</br>" + "Target word: " + dictionary.get(word);
        return result;
    }

}
