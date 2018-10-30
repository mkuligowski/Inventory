package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class InventoryServiceTest {

    private InventoryService inventoryService; // initialize your InventoryService implementation

    @Test
    public void testGetTotalQuantity() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setCode("FTXYZ234");
        Product product3 = new Product();
        product2.setCategory(Category.MOBILE);
        product2.setCode("FTXYZ231");
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);

        assertThat(inventoryService.getTotalQuantity(),is(3));
    }

    @Test
    public void testGetProductsQuantityByCategory() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setCode("FTXYZ234");
        Product product3 = new Product();
        product3.setCategory(Category.ELECTRONICS);
        product3.setCode("FTXYZ245");
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);

        assertThat(inventoryService.getProductsQuantityByCategory(Category.ELECTRONICS),is(2));
        assertThat(inventoryService.getProductsQuantityByCategory(Category.APPLIANCES),is(1));
        assertThat(inventoryService.getProductsQuantityByCategory(Category.MOBILE),is(0));
    }

    @Test
    public void addProduct_uniqueIdExists() {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setCode("FT1234567");

        Product product2 = new Product();
        product2.setCategory(Category.ELECTRONICS);
        product2.setCode("FT1987654");

        inventoryService.addProduct(product);
        inventoryService.addProduct(product);

        product = inventoryService.getProduct("FT1234567");
        product2 = inventoryService.getProduct("FT1987654");

        assertThat(product.getId(),notNullValue());
        assertThat(product2.getId(),notNullValue());
        assertThat(product.getId(),not(equalTo(product2.getId())));
    }

    @Test(expected = Exception.class)
    public void addProduct_wrongCode() {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setCode("X");

        inventoryService.addProduct(product);
    }

    @Test(expected = Exception.class)
    public void addProduct_noCategory() {
        Product product = new Product();
        product.setCode("FTXYZ123");

        inventoryService.addProduct(product);
    }

    @Test
    public void testAddProduct_defaultExpirationDateIsAdded() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");

        inventoryService.addProduct(product1);

        product1 = inventoryService.getProduct("FTXYZ123");
        assertThat(product1.getExpirationDate(),is( LocalDate.now().plusMonths(1)));
    }

    @Test
    public void testGetProduct() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");
        product1.setExpirationDate(LocalDate.now().plusYears(2));

        LocalDate product2ExpirationDate = LocalDate.now().plusDays(2);
        Product product2 = new Product();
        product2.setCategory(Category.ELECTRONICS);
        product2.setCode("FTXYZ123");
        product2.setExpirationDate(product2ExpirationDate);

        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);

        assertThat(inventoryService.getProduct("FTXYZ123").getExpirationDate(), is(product2ExpirationDate));
    }


    @Test
    public void testGetExpiredProducts() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");
        product1.setExpirationDate(LocalDate.now().minusDays(3));
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setCode("FTXYZ234");
        product2.setExpirationDate(LocalDate.now().minusDays(5));
        Product product3 = new Product();
        product2.setCategory(Category.MOBILE);
        product2.setCode("FTXYZ231");
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);

        assertThat(inventoryService.getExpiredProducts(), hasItems(product1, product2));
    }
}