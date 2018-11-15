package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import com.mkuligowski.inventory.domain.Category;


import java.util.List;
import java.util.ArrayList;

public class MyInventoryService implements InventoryService {

    Inventory invertor;


    public MyInventoryService (Inventory invertor)
    {
        this.invertor=invertor;
    }


    @Override
    public Integer getTotalQuantity() {

        int size = invertor.getProducts().size();
        return size;
    }


    @Override
    public Integer getProductsQuantityByCategory(Category category) {
        int quantityByCategory=0;

    for (Product x:invertor.getProducts())
    {
       if  (x.getCategory()==category)
       {
           quantityByCategory++;
       }
    }
    return quantityByCategory;

    }
}
