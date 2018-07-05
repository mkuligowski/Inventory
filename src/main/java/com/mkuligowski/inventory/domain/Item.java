package com.mkuligowski.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class Item {
    private BigDecimal price;
    private int quantity;

    public List<Item> setItem(Map<Product, Integer> products) {
        List<Item> items = new ArrayList<>();
        for(Map.Entry<Product, Integer> entry: products.entrySet()) {
            items.add(new Item(new BigDecimal(String.valueOf(entry.getKey().getPrice())),entry.getValue()));
        }
        return items;
    }
}
