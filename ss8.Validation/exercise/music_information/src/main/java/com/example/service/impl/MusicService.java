package com.example.service.impl;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void update(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void create(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Optional<Music> findById(int id) {
        return iMusicRepository.findById(id);
    }
}
