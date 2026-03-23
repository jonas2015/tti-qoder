package com.ttigroup.model;

public class Statistics {
    private int employees;
    private int countries;
    private int brands;
    private int years;
    private String revenue;

    public Statistics() {}

    public Statistics(int employees, int countries, int brands, int years, String revenue) {
        this.employees = employees;
        this.countries = countries;
        this.brands = brands;
        this.years = years;
        this.revenue = revenue;
    }

    public int getEmployees() { return employees; }
    public void setEmployees(int employees) { this.employees = employees; }
    public int getCountries() { return countries; }
    public void setCountries(int countries) { this.countries = countries; }
    public int getBrands() { return brands; }
    public void setBrands(int brands) { this.brands = brands; }
    public int getYears() { return years; }
    public void setYears(int years) { this.years = years; }
    public String getRevenue() { return revenue; }
    public void setRevenue(String revenue) { this.revenue = revenue; }
}
