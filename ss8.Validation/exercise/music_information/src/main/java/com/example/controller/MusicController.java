package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/saveCreate")
    public String saveCreate(@ModelAttribute("music") @Valid MusicDto musicDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("music", musicDto);
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.create(music);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        model.addAttribute("musicEx", iMusicService.findById(id).get());
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute("musicEx") @Valid MusicDto musicDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Music music = new Music();
        music.setId(musicDto.getId());
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.update(music);
        return "redirect:/";
    }
}
