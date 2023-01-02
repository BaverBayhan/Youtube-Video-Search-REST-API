package com.project.youtube.extension.Controller;

import com.project.youtube.extension.model.Request;
import com.project.youtube.extension.model.TranscriptList;
import com.project.youtube.extension.model.Video;
import com.project.youtube.extension.repository.VideoService;
import com.project.youtube.extension.service.Client;
import com.project.youtube.extension.service.MyProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    @Autowired
    private VideoService service;

    @PostMapping()
    public ResponseEntity<TranscriptList> getMatchedDurationObjects(@RequestBody Request request)
            throws IOException, InterruptedException
    {
        if(service.existsVideo(request.getUrl()))
        {
            Video video = service.getVideoByURL(request.getUrl());
            TranscriptList subtitle_obj=Client.getTranscriptObject(video.getSubtitle());
            return new ResponseEntity<>(Client.parseSubtitle(request.getKeyword(),subtitle_obj),HttpStatus.CREATED);
        }
        else
        {
            String subtitle = Client.post_request(Client.parseUrl(request.getUrl()));
            Video video=new Video();
            video.setUrl(request.getUrl());
            video.setSubtitle(subtitle);
            if(!Objects.equals(subtitle, Objects.requireNonNull(MyProperty.propertyObject()).getProperty("serverError"))
                    && !Objects.equals(subtitle,Objects.requireNonNull(MyProperty.propertyObject()).getProperty("typeError")))
            {
                service.saveVideo(video);
            }
            TranscriptList subtitle_obj = Client.getTranscriptObject(subtitle);
            return new ResponseEntity<>(Client.parseSubtitle(request.getKeyword(),subtitle_obj),HttpStatus.CREATED);
        }
    }

}
