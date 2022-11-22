package com.project.youtube.extension.model;

import java.util.List;

public class TranscriptList {
    private List<Duration> transcript;

    public TranscriptList() {
    }
    public TranscriptList(List<Duration> transcript) {
        this.transcript = transcript;
    }

    public void showTranscript()
    {
        for (Duration duration : transcript) {
            System.out.println(duration);
        }
    }
    public List<Duration> getTranscript() {
        return transcript;
    }
    public void setTranscript(List<Duration> transcript) {
        this.transcript = transcript;
    }
}
