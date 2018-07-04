package com.mkuligowski.inventory.domain;

import com.mkuligowski.inventory.service.InventoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Setter
@Getter
@Component
public class Inventory implements InventoryService {
    private String name;
    private List<Product> products = new ArrayList<>();

    @Override
    public Integer getTotalQuantity() {
        return IntStream.range(0, getProducts().size())
               .map(n -> getProducts().get(n).getQuantity())
               .sum();
    }

    @Override
    public Integer getProductsQuantityByCategory(Category category) {
        return IntStream.range(0, getProducts().size())
                .filter(n -> getProducts().get(n).getCategory().equals(category))
                .map(n -> getProducts().get(n).getQuantity())
                .sum();
    }

    @Override
    public Integer getProductQuantity(Product product) {
        return product.getQuantity();
    }

    @Override
    public void addProduct(Product product, Integer quantity) throws Exception {
        Product product1 = product;
        if(quantity >=0 && !(getProducts().contains(product)) &&
                        product.getId().length() >= 6 &&
                        product.getId().substring(0,2).equals("FT") &&
                !(product.getCategory().equals(""))) {
            product1.setQuantity(quantity);
            getProducts().add(product1);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void setProductQuantity(Product product, Integer quantity) throws Exception {
        if(quantity >=0) {
            getProducts().stream()
                    .filter(p -> p.equals(product))
                    .forEach(p -> p.setQuantity(quantity));
        } else {
            throw new Exception();
        }
    }
}
