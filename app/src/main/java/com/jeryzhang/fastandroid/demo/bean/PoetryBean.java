package com.jeryzhang.fastandroid.demo.bean;


public class PoetryBean {
    private String author;
    private String origin;
    private String category;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PoetryBean{" +
                "author='" + author + '\'' +
                ", origin='" + origin + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
