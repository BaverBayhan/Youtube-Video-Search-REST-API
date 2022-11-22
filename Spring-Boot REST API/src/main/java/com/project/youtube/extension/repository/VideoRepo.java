package com.project.youtube.extension.repository;

import com.project.youtube.extension.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {
    @Query("SELECT u FROM Video u WHERE u.url = :url ")
    Video getVideoByURL(@Param("url") String URL);

    @Query("DELETE FROM Video u WHERE u.url = :url ")
    void deleteVideoByURL(@Param("url") String URL);
}
