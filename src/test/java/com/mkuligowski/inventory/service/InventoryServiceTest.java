package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryServiceTest {

    private InventoryService inventoryService; // initialize your InventoryService implementation


    @Test(expected = Exception.class)
    public void addProduct_wrongCode() {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setId("X");

        inventoryService.addProduct(product, 1);
    }

    @Test(expected = Exception.class)
    public void addProduct_wrongQuantity() {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setId("FTXYZ123");

        inventoryService.addProduct(product, -1);
    }

    @Test(expected = Exception.class)
    public void addProduct_noCategory() {
        Product product = new Product();
        product.setId("FTXYZ123");

        inventoryService.addProduct(product, 1);
    }

    @Test(expected = Exception.class)
    public void testAddProduct_sameProductTwice() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");

        Product product2 = new Product();
        product2.setCategory(Category.ELECTRONICS);
        product2.setId("FTXYZ123");

        inventoryService.addProduct(product1, 1);
        inventoryService.addProduct(product2, 1);
    }


}