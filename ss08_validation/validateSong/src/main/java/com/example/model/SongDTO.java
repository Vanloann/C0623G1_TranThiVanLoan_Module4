package com.example.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO {

    @NotEmpty
    @Size(min = 1, max = 800, message = "Length of song name must not exceed 800 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "Song name cannot include special characters (@ ; , . = - + , ….)")
    private String name;

    @NotEmpty
    @Size(min = 1, max = 300, message = "Length of singer name must not exceed 300 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+", message = "Singer name cannot include special characters (@ ; , . = - + , ….)")
    private String singer;

    @NotEmpty
    @Size(min = 1, max = 1000, message = "Genre must not exceed 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+", message = "Singer name cannot include special characters(@ ; , . = - + , ….) except for comma")
    private String genre;

    public SongDTO() {
    }

    public SongDTO(String name, String singer, String genre) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
