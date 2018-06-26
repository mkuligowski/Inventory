package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Product;

import java.util.Map;
import java.util.Set;

public interface InventoryService {

    Integer getTotalQuantity();
    Integer getProductsQuantityByCategory(Category category);
    Integer getProductQuantity(Product product);
    Map<Product, Integer> getProducts();
    void addProduct(Product product, Integer quantity);
    void setProductQuantity(Product product, Integer quantity);
}
