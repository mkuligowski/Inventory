package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Product;
import java.util.List;

public interface ShopService {

    Float GetTotalPriceOfProducts(List<Product> products);
}
