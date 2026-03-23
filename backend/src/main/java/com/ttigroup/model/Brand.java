package com.ttigroup.model;

public class Brand {
    private Long id;
    private String name;
    private String logo;
    private String productImage;
    private String description;
    private String category;

    public Brand() {}

    public Brand(Long id, String name, String logo, String productImage, String description, String category) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.productImage = productImage;
        this.description = description;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
    public String getProductImage() { return productImage; }
    public void setProductImage(String productImage) { this.productImage = productImage; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
