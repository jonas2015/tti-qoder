package com.ttigroup.model;

import java.time.LocalDate;

public class NewsArticle {
    private Long id;
    private String title;
    private String content;
    private String excerpt;
    private LocalDate date;
    private String category;
    private String imageUrl;

    public NewsArticle() {}

    public NewsArticle(Long id, String title, String content, String excerpt, LocalDate date, String category, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.excerpt = excerpt;
        this.date = date;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getExcerpt() { return excerpt; }
    public void setExcerpt(String excerpt) { this.excerpt = excerpt; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
