package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Inventory;
import com.mkuligowski.inventory.domain.Product;
import com.mkuligowski.inventory.domain.Category;

import com.mkuligowski.inventory.exceptions.ValidationException;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class MyInventoryService implements InventoryService {

   private Inventory inventoryWorker;




    public MyInventoryService (Inventory inventoryWorker)
    {

    this.inventoryWorker = inventoryWorker;



    }




    @Override
    public Integer getTotalQuantity() {

        return inventoryWorker.getProducts().size();

    }


    @Override
    public Integer getProductsQuantityByCategory(Category category) {
        int quantityByCategory=0;

    for (Product x:inventoryWorker.getProducts())
    {
       if  (x.getCategory().equals(category))
       {
           quantityByCategory++;
       }
    }
    return quantityByCategory;

    }


    public Product getProduct(String code)
    {
    List <Product> productList= new ArrayList<>();
    Product tempProduct = new Product();

    for (Product x:inventoryWorker.getProducts())
    {
      if (x.getCode().equals(code))
      {
          productList.add(x);
      }
    }
    if (productList.isEmpty()){

        return null;

    }
    else if (productList.size()==1)
    {
        tempProduct=productList.get(0);
    }
    else
    {
        tempProduct=productList.get(0);
        for (Product x:productList)
        {
            if (tempProduct.getExpirationDate().isAfter(x.getExpirationDate()))
            {
                tempProduct=x;
            }
        }
    }
    return tempProduct;
    }


    public void addProduct(Product product)

    {

    if (product.getCode().length()<6)
    {
        throw new ValidationException("Product code must have minimum 6 characters ");
    }
    if (!product.getCode().startsWith("FT"))
    {
        throw new ValidationException("Product code have to start at FT");
    }
    if (product.getCategory()==null)
    {
        throw new ValidationException("Product have to set category");
    }
  if (product.getExpirationDate()==null)
    {
        product.setExpirationDate(LocalDate.now().plusMonths(1));
    }
    inventoryWorker.getProducts().add(product);




    }



    public List<Product> getExpiredProducts()
    {
        List <Product> tempProductList = new ArrayList<>();

        for (Product x:inventoryWorker.getProducts())
        {
            if (x.getExpirationDate().isBefore(LocalDate.now()))
            {
                tempProductList.add(x);
            }
        }

        return tempProductList;
    }

    public List<Product> getAllProducts()
    {
     List<Product> allProducts = new ArrayList<>();
     allProducts=inventoryWorker.getProducts();

     return allProducts;
    }
}
