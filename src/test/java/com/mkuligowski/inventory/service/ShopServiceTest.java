package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

    @Autowired
    private Inventory inventory;

    @Autowired
    private ShopService shopService;

    @Test
    public void testGetTotalPrice() throws Exception {
        //Given
        Product product1 = new Product();
        product1.setCategory(Category.MOBILE);
        product1.setId("FTXYZ123");
        product1.setPrice(new BigDecimal("10.01"));
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setId("FTXYZ234");
        product2.setPrice(new BigDecimal("20.0"));
        Product product3 = new Product();
        product3.setCategory(Category.ELECTRONICS);
        product3.setId("FTXYZ245");
        product3.setPrice(new BigDecimal("30.1"));
        inventory.addProduct(product1, 2);
        inventory.addProduct(product2, 3);
        inventory.addProduct(product3, 7);

        //When
        BigDecimal expectedPrice = new BigDecimal("290.72");
        BigDecimal totalPrice = shopService.getTotalPriceProducts(inventory.getProducts());

        //Then
        Assert.assertEquals(expectedPrice, totalPrice);

    }
}
