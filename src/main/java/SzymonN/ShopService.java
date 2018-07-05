package SzymonN;

import com.mkuligowski.inventory.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    public double ValueOfAllProducts(List<Product> products)
    {
        double sum_price=0;
        for (Product p:products)
            sum_price+=p.getPrice();
        return sum_price;
    }
}
