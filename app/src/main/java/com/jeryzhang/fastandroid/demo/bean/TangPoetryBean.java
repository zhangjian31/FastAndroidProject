package com.jeryzhang.fastandroid.demo.bean;

public class TangPoetryBean {
    private String title;
    private String content;
    private String authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "TangPoetryBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authors='" + authors + '\'' +
                '}';
    }
}
