package com.ttigroup.service;

import com.ttigroup.model.CompanyInfo;
import com.ttigroup.model.Leader;
import com.ttigroup.model.Statistics;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class CompanyInfoService {

    public CompanyInfo getCompanyInfo() {
        List<Leader> leadership = Arrays.asList(
            new Leader("John G. Raos", "Chief Executive Officer", "https://images.unsplash.com/photo-1560250097-0b93528c311a?w=400"),
            new Leader("Victoria S. Chen", "Chief Financial Officer", "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=400"),
            new Leader("Michael R. Thompson", "President, Power Tools", "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=400"),
            new Leader("Sarah K. Williams", "President, Floor Care", "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=400")
        );

        Statistics stats = new Statistics(
            28000,
            100,
            15,
            40,
            "$8.2B"
        );

        return new CompanyInfo(
            "TTi Group",
            "TTi Group is a global leader in design, manufacture, and marketing of home improvement and floor care products. Founded in 1985, we have grown to become one of the largest tool companies in the world, with a portfolio of trusted brands that professionals and consumers rely on every day.",
            "Founded in 1985, TTi Group has grown from a small power tool distributor to a global leader in the home improvement industry. Our journey began with a commitment to quality and innovation, which remains at the core of everything we do today.",
            "To be the world's most trusted provider of innovative tools and solutions, empowering professionals and consumers to build, create, and care for their homes.",
            "We are committed to delivering superior quality products, investing in our people, and creating sustainable value for our shareholders while making a positive impact on the communities we serve.",
            leadership,
            stats
        );
    }
}
