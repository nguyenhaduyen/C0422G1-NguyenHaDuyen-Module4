package com.example.service;

import com.example.model.Music;

import java.util.List;
import java.util.Optional;

public interface IMusicService {

    List<Music> findAll();

    void update(Music music);

    void create(Music music);

    Optional<Music> findById(int id);
}
