package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ShopServiceTest {

    private InventoryService inventoryService  ;  // initialize your InventoryService implementation
    private ShopService shopService;
    @Before
    public void setUp() throws Exception {
        Inventory inventory = new Inventory();
        inventory.setName("TestInventory");
        inventory.setProducts(new ArrayList<>());
        inventoryService = new MyInventoryService(inventory);
        shopService = new MyShopService();
    }

    @Test
    public void testGetTotalQuantity() {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setCode("FTXYZ123");
        product1.setPrice(46.44f);
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setCode("FTXYZ234");
        product2.setPrice(12.56f);
        Product product3 = new Product();
        product3.setCode("FTXHHGDDSA");
        product3.setCategory(Category.MOBILE);
        product3.setPrice(41.00f);
        inventoryService.addProduct(product1);
        inventoryService.addProduct(product2);
        inventoryService.addProduct(product3);

        assertThat(shopService.GetTotalPriceOfProducts(inventoryService.getAllProducts()),is(100f));
    }





}
