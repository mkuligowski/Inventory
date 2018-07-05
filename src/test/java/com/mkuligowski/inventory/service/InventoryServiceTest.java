package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTest {

    private InventoryService inventoryService;  // initialize your InventoryService implementation

    @Before
    public void initializeInventoryService() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.mkuligowski.inventory");
        inventoryService = context.getBean(Inventory.class);
    }

    @Test(expected = Exception.class)
    public void addProduct_wrongCode() throws Exception {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setId("X");

        inventoryService.addProduct(product, 1);
    }

    @Test(expected = Exception.class)
    public void addProduct_wrongQuantity() throws Exception {
        Product product = new Product();
        product.setCategory(Category.ELECTRONICS);
        product.setId("FTXYZ123");

        inventoryService.addProduct(product, -1);
    }

    @Test(expected = Exception.class)
    public void addProduct_noCategory() throws Exception {
        Product product = new Product();
        product.setId("FTXYZ123");

        inventoryService.addProduct(product, 1);
    }

    @Test(expected = Exception.class)
    public void testAddProduct_sameProductTwice() throws Exception{
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
    public void testAddProduct() throws Exception {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));

        inventoryService.setProductQuantity(product1, 2);

        assertThat(inventoryService.getProductQuantity(product1), is(2));
    }

    @Test(expected = Exception.class)
    public void testUpdateProduct_wrongQuantity() throws Exception {
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        inventoryService.addProduct(product1, 1);

        assertThat(inventoryService.getProductQuantity(product1), is(1));

        inventoryService.setProductQuantity(product1, -2);
    }

    @Test
    public void testGetTotalQuantity() throws Exception {
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
    public void testGetProductsQuantityByCategory() throws Exception {
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