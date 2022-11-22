package com.project.youtube.extension.model;

public class Request {
    String url;
    String keyword;

    public Request() {
    }
    public Request(String url, String keyword) {
        this.url = url;
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String URL) {
        this.url = URL;
    }
}
