package com.project.youtube.extension.model;

import lombok.ToString;

@ToString
public class Duration {
    private String text;
    private double start;
    private double duration;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }


}
