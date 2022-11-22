package com.project.youtube.extension.service;

import com.project.youtube.extension.model.Video;
import com.project.youtube.extension.repository.VideoService;
import com.project.youtube.extension.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepo repository;
    @Override
    public Video getVideoByURL(String URL) {
        return repository.getVideoByURL(URL);
    }
    @Override
    public void deleteVideoByURL(String URL) {
        repository.deleteVideoByURL(URL);
    }
    @Override
    public void saveVideo(Video video) {
        repository.save(video);
    }
    @Override
    public boolean existsVideo(String URL) {
        return repository.getVideoByURL(URL) != null;
    }
}
