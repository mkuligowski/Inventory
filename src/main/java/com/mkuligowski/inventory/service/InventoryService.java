package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Product;

public interface InventoryService {
    Integer getTotalQuantity();
    Integer getProductsQuantityByCategory(Category category);
    Integer getProductQuantity(Product product);
    void addProduct(Product product, Integer quantity);
    void setProductQuantity(Product product, Integer quantity);
}