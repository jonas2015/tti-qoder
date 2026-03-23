package com.ttigroup.controller;

import com.ttigroup.model.NewsArticle;
import com.ttigroup.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<NewsArticle>> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsArticle> getNewsById(@PathVariable Long id) {
        NewsArticle article = newsService.getNewsById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        }
        return ResponseEntity.notFound().build();
    }
}
