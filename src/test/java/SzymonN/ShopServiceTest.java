package SzymonN;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.eventFrom;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShopServiceTest {
    private Inventory inventory = new Inventory("MyBackpack");

    @Test
    public void valueOfAllProducts() {
        ShopService shopService = new ShopService();
        ///////////
        Product product1 = new Product();
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        product1.setPrice(new BigDecimal("50.01"));
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setId("FTXYZ234");
        product2.setPrice(new BigDecimal("99.99"));
        Product product3 = new Product();
        product3.setCategory(Category.ELECTRONICS);
        product3.setId("FTXYZ245");
        product3.setPrice(new BigDecimal("200.00"));
        inventory.addProduct(product1, 2);
        inventory.addProduct(product2, 2);
        inventory.addProduct(product3, 5);
        //////////////
        BigDecimal actualCost= shopService.ValueOfAllProducts(inventory.getSlotsOfProducts());
        BigDecimal expectedCost=new BigDecimal("1300.00");

        Assert.assertEquals(expectedCost,actualCost);
    }
}