package com.exercise.service.impl;

import com.exercise.model.Music;
import com.exercise.repository.IMusicRepository;
import com.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        String fileName = null;
//         Step 3: Process with File
        try {
            fileName = music.getMusicFile().getOriginalFilename();

            FileCopyUtils.copy(music.getMusicFile().getBytes(),
                    new File("D:\\up\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        music.setLink(fileName);
        iMusicRepository.create(music);
    }

    @Override
    public Music findId(int id) {
        return iMusicRepository.findId(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }
}
