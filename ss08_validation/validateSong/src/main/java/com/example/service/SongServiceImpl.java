package com.example.service;

import com.example.model.Song;
import com.example.model.SongDTO;
import com.example.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepo songRepo;

    @Override
    public List<Song> showList() {
        return songRepo.findAll();
    }

//    @Override
//    public Song findById(int id) {
//        return songRepo.findById(id).get();
//    }

    @Override
    public Optional<Song> findById(int id) {
        return songRepo.findById(id);
    }


    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public void update(int id, Song song) {
        songRepo.save(song);
    }
}
