package com.mkuligowski.inventory.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private Long id;
    private static Long nextId=0L;
    private Category category;
    private String code;
    private LocalDate expirationDate;
    private Float price;


    public Product()
    {
        id=nextId++;

    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                category == product.category;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, category);
    }




}
