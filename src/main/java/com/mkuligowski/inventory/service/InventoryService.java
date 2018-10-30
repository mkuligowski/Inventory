package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Product;

import java.util.List;

public interface InventoryService {
    Integer getTotalQuantity();
    Integer getProductsQuantityByCategory(Category category);
    Product getProduct(String code);
    void addProduct(Product product);
    List<Product> getExpiredProducts();
}