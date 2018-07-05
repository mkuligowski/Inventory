package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InventoryServiceTest {

    private InventoryService inventoryService = new Inventory();


    @Test(expected = Exception.class)
    public void addProduct_wrongCode(){
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

    @Test
    public void testAddProduct() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));
    }

    @Test
    public void testUpdateProduct() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));

        inventoryService.setProductQuantity(product1, 2);

        assertThat(inventoryService.getProductQuantity(product1), is(2));
    }

    @Test(expected = Exception.class)
    public void testUpdateProduct_wrongQuantity() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));

        inventoryService.setProductQuantity(product1, -2);
    }

    @Test
    public void testGetTotalQuantity() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setId("FTXYZ234");
        inventoryService.addProduct(product1, 1);
        inventoryService.addProduct(product2, 3);

        assertThat(inventoryService.getTotalQuantity(),is(4));
    }

    @Test
    public void testGetProductsQuantityByCategory() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setId("FTXYZ234");
        Product product3 = new Product();
        product3.setCategory(Category.ELECTRONICS);
        product3.setId("FTXYZ245");
        inventoryService.addProduct(product1, 2);
        inventoryService.addProduct(product2, 3);
        inventoryService.addProduct(product3, 7);

        assertThat(inventoryService.getProductsQuantityByCategory(Category.ELECTRONICS),is(9));
    }
}