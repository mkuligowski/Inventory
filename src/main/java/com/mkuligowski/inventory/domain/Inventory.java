package com.mkuligowski.inventory.domain;

import com.mkuligowski.inventory.service.InventoryService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@Component
public class Inventory implements InventoryService {
    private String name;
    private Map<Product, Integer> products = new HashMap<>();

    @Override
    public Integer getTotalQuantity() {
        return getProducts().entrySet().stream()
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    @Override
    public Integer getProductsQuantityByCategory(Category category) {
        return getProducts().entrySet().stream()
                .filter(p -> p.getKey().getCategory().equals(category))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    @Override
    public Integer getProductQuantity(Product product) {
        return getProducts().get(product);
    }

    @Override
    public void addProduct(Product product, Integer quantity) throws Exception {
        if(quantity >=0 &&
                product.getId().length() >= 6 &&
                product.getId().substring(0,2).equals("FT") &&
                !(product.getCategory().equals(""))&&
                !(getProducts().containsKey(product))) {
            getProducts().put(product,quantity);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void setProductQuantity(Product product, Integer quantity) throws Exception {
        if(quantity >= 0) {
            getProducts().put(product,quantity);
        } else {
            throw new Exception();
        }
    }
}
