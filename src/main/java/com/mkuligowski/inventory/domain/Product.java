package com.mkuligowski.inventory.domain;

import com.mkuligowski.inventory.service.InventoryService;
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.util.Objects;

public class Product {

    private String id;
    private Category category;
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {

        id=id.toUpperCase();

        if(id.substring(0,2).equals("FT")&& id.length()>=6)
        {
            this.id = id;
        }
        else {
            throw new ClassFormatException();
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
