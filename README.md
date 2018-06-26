# Inventory Service

### 1. Setup
* Fork the repository (https://help.github.com/articles/fork-a-repo/)
* Clone the repository and import it to the IntelliJ (https://www.jetbrains.com/help/idea/gradle.html#gradle_import)
* When ready, create Pull Request (https://help.github.com/articles/creating-a-pull-request-from-a-fork/)

### 2. Exercise 1 - Implementation of _InventoryService_

* Create implementation of the __InventoryService__
* _getTotalQuantity()_ - should return total quantity of all products
* _getProductsQuantityByCategory()_ - should return quantity by some category
* _getProductQuantity()_ - should return quantity of the product
* _ addProduct()_ - adds product to the inventory.
    * You should not be able to add product with the **same code twice**
	* You should not be able to add product with **negative quantity**
	* Product id should have **at least 6 characters** and should **have _FT_ prefix** for example FTXYZ1, FTXYZ2 etc.
	* Product category **is mandatory**
* _setProductQuantity()_ - updates product quantiy
	* You should not be able to update product with **negative quantity**

When ready, please initialize your _InventoryService_ service in _InventoryServiceTest_. For example:

    public class InventoryServiceTest {
        private InventoryService inventoryService = new MyAwesomeInventoryService();
    }

### 3. Exercise 2 - Implementation of _ShopService_

* Create new class - _ShopService_
* Add price attribute to the _Product_ class
* Create method that accept _List_ of products and return total price
