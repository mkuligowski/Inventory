package com.mkuligowski.inventory.domain;

import com.mkuligowski.inventory.service.InventoryService;
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;
import com.sun.org.apache.bcel.internal.generic.ClassGen;
import com.sun.org.apache.bcel.internal.generic.ClassGenException;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryService {

    public Inventory()
    {
        products= new ArrayList<Product>();
    }
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
//////////////
    @Override
    public Integer getProductQuantity(Product product) {

        int count=0;
        for (Product prod:products) {
            if(prod.equals(product))
                count++;
        }
        return count;
    }

    @Override
    public Integer getProductsQuantityByCategory(Category category) {
        int count=0;
        for (Product prod:products) {
            if(prod.getCategory().equals(category))
                count++;
        }
        return count;
    }

    @Override
    public Integer getTotalQuantity() {
        return products.size();
    }

    @Override
    public void setProductQuantity(Product product, Integer quantity) {

        if(quantity<0)
            throw new ClassFormatException();
        int numberOfProducts = getProductQuantity(product);

        if(numberOfProducts<=quantity){
            numberOfProducts=quantity-numberOfProducts;
            while (numberOfProducts!= 0)
            {
                products.add(product);
                numberOfProducts--;
            }
        }
        else
        {
            numberOfProducts=numberOfProducts-quantity;
            while (numberOfProducts!= 0)
            {
                products.remove(product);
                numberOfProducts--;
            }
        }
    }

    @Override
    public void addProduct(Product product, Integer quantity) {
        if(quantity<0 || product.getCategory()== null)
            throw new ClassFormatException();

            //String string_tmp=product.getId().substring(2);
            for (Product p:products)
                //if (p.getId().substring(2).equals(string_tmp))
                if(product.hashCode()== p.hashCode())
                    throw new ClassFormatException();

        products.add(product);
        setProductQuantity(product,quantity);
    }
}
