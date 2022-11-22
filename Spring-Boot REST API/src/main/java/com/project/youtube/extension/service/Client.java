package com.project.youtube.extension.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.project.youtube.extension.model.Duration;
import com.project.youtube.extension.model.TranscriptList;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Client{

    public static String post_request(String youtube_id) throws IOException, InterruptedException {

        var values = new HashMap<String, String>() {{
            put("youtube_id", youtube_id);
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8000/api/v1/videos"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static TranscriptList getTranscriptObject(String subtitle) throws IOException, InterruptedException {
        Gson g = new Gson();
        return g.fromJson(subtitle, TranscriptList.class);
    }

    public static TranscriptList parseSubtitle(String keyword, TranscriptList subtitles) {
        List<Duration> result_list = new ArrayList<>();
        List<Duration> durationList = subtitles.getTranscript();
        for (Duration duration : durationList) {
            String[] arr = duration.getText().split(" ");
            for (String word :arr) {
                if(word.equals(keyword))
                {
                    result_list.add(duration);
                }
            }
        }
        return new TranscriptList(result_list);
    }

    public static String parseUrl(String url)
    {
        int index_of_id=url.indexOf("watch?v=")+8;
        return url.substring(index_of_id,index_of_id+11);
    }
}
