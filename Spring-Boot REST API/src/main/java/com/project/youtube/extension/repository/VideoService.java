package com.project.youtube.extension.repository;
import com.project.youtube.extension.model.Video;

public interface VideoService{
    Video getVideoByURL(String URL);
    void deleteVideoByURL(String URL);
    void saveVideo(Video video);

    boolean existsVideo(String URL);
}
