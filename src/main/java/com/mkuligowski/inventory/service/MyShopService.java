package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Product;
import java.util.List;

public class MyShopService implements ShopService {

  public  Float GetTotalPriceOfProducts(List<Product> products)
    {
        Float total=0.0f;

        for(Product x:products)
        {
            total=total+x.getPrice();
        }

        return total;
    }



}
