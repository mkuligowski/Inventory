package com.mkuligowski.inventory.domain;

import com.mkuligowski.inventory.service.InventoryService;
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService {

    public Inventory(String _name) {
        slotsOfProducts = new ArrayList<SlotProduct>();
        name=_name;
    }

    private String name;

    private List<SlotProduct> slotsOfProducts;

    public String getName() {
        return name;
    }

    public List<SlotProduct> getSlotsOfProducts() {
        return slotsOfProducts;
    }

    public void setSlotsOfProducts(List<SlotProduct> slotsOfProducts) {
        this.slotsOfProducts = slotsOfProducts;
    }

    //////////////
    @Override
    public Integer getProductQuantity(Product product) {

        for (SlotProduct p : slotsOfProducts) {
            if (p.product.hashCode() == product.hashCode())
                return p.getQuantity();
        }
        return 0;
    }

    @Override
    public Integer getProductsQuantityByCategory(Category category) {

        return slotsOfProducts.stream().
                filter(p -> p.product.getCategory() == category).
                mapToInt(prod -> prod.getQuantity()).sum();
    }

    @Override
    public Integer getTotalQuantity() {

        return slotsOfProducts.stream().mapToInt(prod -> prod.getQuantity()).sum();
    }

    @Override
    public void setProductQuantity(Product product, Integer quantity) {
        if (quantity > 0) {
            slotsOfProducts.stream().
                    filter(s -> s.product.hashCode() == product.hashCode()).
                    findAny().get().setQuantity(quantity);
        } else
            throw new ClassFormatException();
    }

    @Override
    public void addProduct(Product product, Integer quantity) {

        if (quantity > 0 && product.getCategory() != null) {
            for (SlotProduct p : slotsOfProducts)
                if (p.getProduct().hashCode() == product.hashCode())
                    throw new ClassFormatException();

            slotsOfProducts.add(new SlotProduct(product, quantity));
        } else
            throw new ClassFormatException();
    }
}
