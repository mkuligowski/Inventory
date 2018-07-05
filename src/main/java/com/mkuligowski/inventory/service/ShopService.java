package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Item;
import com.mkuligowski.inventory.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ShopService {
    public BigDecimal getTotalPriceProducts(List<Item> items) {
        return items.stream()
                .map(i -> i.getPrice().multiply(new BigDecimal(String.valueOf(i.getQuantity()))))
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));
    }
}
