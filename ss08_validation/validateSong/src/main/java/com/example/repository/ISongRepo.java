package com.example.repository;

import com.example.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song, Integer> {
}
