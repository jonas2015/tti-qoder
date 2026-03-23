package com.ttigroup.service;

import com.ttigroup.model.Brand;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class BrandService {

    public List<Brand> getAllBrands() {
        return Arrays.asList(
            new Brand(1L, "Milwaukee", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Milwaukee_Electric_Tool_Corp_logo.svg/200px-Milwaukee_Electric_Tool_Corp_logo.svg.png",
                "https://images.unsplash.com/photo-1504148455328-c376907d081c?w=400&h=300&fit=crop", "Professional power tools", "Power Tools"),
            new Brand(2L, "Ryobi", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Ryobi_logo.svg/200px-Ryobi_logo.svg.png",
                "https://images.unsplash.com/photo-1580894894513-541e068a3e2b?w=400&h=300&fit=crop", "DIY power tools", "Power Tools"),
            new Brand(3L, "Hoover", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Hoover_Logo.svg/200px-Hoover_Logo.svg.png",
                "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400&h=300&fit=crop", "Floor care appliances", "Floor Care"),
            new Brand(4L, "Dyson", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Dyson_logo.svg/200px-Dyson_logo.svg.png",
                "https://images.unsplash.com/photo-1527515637462-cff94eecc1ac?w=400&h=300&fit=crop", "Vacuum cleaners and fans", "Floor Care"),
            new Brand(5L, "Vax", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Vax_logo.svg/200px-Vax_logo.svg.png",
                "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400&h=300&fit=crop", "Carpet cleaners", "Floor Care"),
            new Brand(6L, "Oreck", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Oreck_logo.svg/200px-Oreck_logo.svg.png",
                "https://images.unsplash.com/photo-1556909172-54557c7e4fb7?w=400&h=300&fit=crop", "Commercial vacuums", "Floor Care"),
            new Brand(7L, "Bissell", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Bissell_logo.svg/200px-Bissell_logo.svg.png",
                "https://images.unsplash.com/photo-1583947215259-38e31be8751f?w=400&h=300&fit=crop", "Home cleaning", "Floor Care"),
            new Brand(8L, "Dremel", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Dremel_logo.svg/200px-Dremel_logo.svg.png",
                "https://images.unsplash.com/photo-1530124566582-a618bc2615dc?w=400&h=300&fit=crop", "Rotary tools", "Power Tools"),
            new Brand(9L, "Craftsman", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Craftsman_logo.svg/200px-Craftsman_logo.svg.png",
                "https://images.unsplash.com/photo-1580901368919-7738efb0f87e?w=400&h=300&fit=crop", "Hand tools", "Hand Tools"),
            new Brand(10L, "Stanley", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Stanley_Black_%26_Decker_logo.svg/200px-Stanley_Black_%26_Decker_logo.svg.png",
                "https://images.unsplash.com/photo-1572981779307-38b8cabb2407?w=400&h=300&fit=crop", "Hand tools", "Hand Tools"),
            new Brand(11L, "DeWalt", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/DEWALT_logo.svg/200px-DEWALT_logo.svg.png",
                "https://images.unsplash.com/photo-1504148455328-c376907d081c?w=400&h=300&fit=crop", "Professional tools", "Power Tools"),
            new Brand(12L, "Makita", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Makita_logo.svg/200px-Makita_logo.svg.png",
                "https://images.unsplash.com/photo-1580894732444-8ecded7900cd?w=400&h=300&fit=crop", "Power tools", "Power Tools")
        );
    }
}
