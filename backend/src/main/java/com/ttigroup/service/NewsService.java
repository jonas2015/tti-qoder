package com.ttigroup.service;

import com.ttigroup.model.NewsArticle;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsService {

    public List<NewsArticle> getAllNews() {
        return Arrays.asList(
            new NewsArticle(1L, "TTi Group Announces Record Financial Results for 2025",
                "TTi Group today announced record financial results for the fiscal year 2025, with revenue reaching $8.2 billion, a 12% increase year-over-year. The strong performance was driven by growth in our power tools segment and expansion into new markets.",
                "TTi Group today announced record financial results for the fiscal year 2025...", LocalDate.of(2026, 2, 15), "Financial", "https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=800"),
            new NewsArticle(2L, "Milwaukee Tool Launches New M18 FUEL Platform",
                "Milwaukee Tool, a division of TTi Group, announced the launch of its next-generation M18 FUEL platform, featuring breakthrough battery technology and enhanced performance capabilities for professional contractors.",
                "Milwaukee Tool announced the launch of its next-generation M18 FUEL platform...", LocalDate.of(2026, 1, 28), "Product", "https://images.unsplash.com/photo-1504148455328-c376907d081c?w=800"),
            new NewsArticle(3L, "TTi Group Expands Sustainability Initiatives",
                "TTi Group expands its commitment to sustainability with new goals for carbon neutrality by 2030 and increased use of recycled materials in product packaging across all brands.",
                "TTi Group expands its commitment to sustainability with new goals...", LocalDate.of(2026, 1, 10), "Sustainability", "https://images.unsplash.com/photo-1473341304170-971dccb5ac1e?w=800"),
            new NewsArticle(4L, "TTi Group Named One of America's Best Employers",
                "For the third consecutive year, TTi Group has been named one of America's Best Employers by Forbes, recognizing our commitment to workplace culture, employee development, and diversity initiatives.",
                "TTi Group has been named one of America's Best Employers by Forbes...", LocalDate.of(2025, 12, 20), "Awards", "https://images.unsplash.com/photo-1521737711867-e3b97375f902?w=800"),
            new NewsArticle(5L, "Ryobi Brand Celebrates 40th Anniversary",
                "Ryobi celebrates its 40th anniversary, marking four decades of innovation in DIY power tools. Since its founding, Ryobi has become a household name, serving millions of homeowners and hobbyists worldwide.",
                "Ryobi celebrates its 40th anniversary, marking four decades of innovation...", LocalDate.of(2025, 11, 15), "Milestone", "https://images.unsplash.com/photo-1581092160562-40aa08e78837?w=800")
        );
    }

    public NewsArticle getNewsById(Long id) {
        return getAllNews().stream()
            .filter(news -> news.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
