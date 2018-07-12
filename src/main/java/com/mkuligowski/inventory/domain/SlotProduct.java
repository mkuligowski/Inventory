package com.mkuligowski.inventory.domain;

public class SlotProduct {
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    Product product;
    SlotProduct(Product _product, int _quantity){
        quantity=_quantity;
        product=_product;
    }
}
