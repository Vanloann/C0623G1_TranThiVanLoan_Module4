package com.example.service;

import com.example.model.Song;
import com.example.model.SongDTO;

import java.util.List;
import java.util.Optional;


public interface ISongService {

    List<Song> showList();

    Optional<Song> findById(int id);

//    Song findById(int id);

    void save(Song song);

    void update(int id, Song song);
}
