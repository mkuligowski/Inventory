package SzymonN;

import com.mkuligowski.inventory.domain.Category;
import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import com.mkuligowski.inventory.service.InventoryService;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.Matchers.eventFrom;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShopServiceTest {
    private Inventory inventory = new Inventory();

    @Test
    public void valueOfAllProducts() {
        Product product1 = new Product();
        ShopService shopService = new ShopService();

        assertThat(shopService.ValueOfAllProducts(inventory.getProducts()), is((double) 0));
        ///////////
        product1.setCategory(Category.ELECTRONICS);
        product1.setId("FTXYZ123");
        product1.setPrice(50);
        Product product2 = new Product();
        product2.setCategory(Category.APPLIANCES);
        product2.setId("FTXYZ234");
        product2.setPrice(100);
        Product product3 = new Product();
        product3.setCategory(Category.ELECTRONICS);
        product3.setId("FTXYZ245");
        product3.setPrice(200);
        inventory.addProduct(product1, 2);
        inventory.addProduct(product2, 3);
        inventory.addProduct(product3, 7);
        //////////////
        assertThat(shopService.ValueOfAllProducts(inventory.getProducts()), is((double) 1800));
    }
}