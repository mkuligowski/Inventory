package com.mkuligowski.inventory.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private String id;
    private Category category;
    private LocalDate expirationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
