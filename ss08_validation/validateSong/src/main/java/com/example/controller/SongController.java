package com.example.controller;

import com.example.model.Song;
import com.example.model.SongDTO;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public ModelAndView showList() {
        List<Song> songList = songService.showList();
        return new ModelAndView("song", "songList", songList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "songDTO", new SongDTO());
    }

    @PostMapping("/create")
    public String create(@Validated  @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "add new song successfully");
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Integer id) {
//        Song song = songService.findById(id);
        Optional<Song> song = songService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song.get(), songDTO);
        return new ModelAndView("update", "songDTO", songDTO);
    }

    @PostMapping("/update/{id}")
    public String update(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult, @PathVariable Integer id) {
        if (bindingResult.hasFieldErrors()) {
            return "update";
        } else {
//            Song song = songService.findById(id);
            Optional<Song> song = songService.findById(id);
            BeanUtils.copyProperties(songDTO, song.get());
            songService.save(song.get());
            return "redirect:/";
        }
    }
}
