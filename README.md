# Inventory Service v2

### 1. Setup
* Fork the repository (https://help.github.com/articles/fork-a-repo/)
* Clone the repository and import it to the IntelliJ (https://www.jetbrains.com/help/idea/gradle.html#gradle_import)
* When ready, create Pull Request (https://help.github.com/articles/creating-a-pull-request-from-a-fork/)

### 2. Exercise 1 - Implementation of _InventoryService_

* Create implementation of the __InventoryService__
* _getTotalQuantity()_ - should return total quantity of all products
* _getProductsQuantityByCategory()_ - should return quantity by some category
* _addProduct()_ - adds product to the inventory.
    * Product ID should be assigned automatically, and should be unique for each Product
	* Product code should have **at least 6 characters** and should **have _FT_ prefix** for example FTCARPET, FTMOBILE etc.
	* Product category **is mandatory**
	* When expiration date is not provided, then it should be one month greater than the date the product was added
* _getProduct()_ - should return product by code
	* When more then one product exists with same code, then one with earlier expiration date is returned
* _getExpiredProducts()_ should return list of products with expiration date less than current date

When ready, please initialize your _InventoryService_ service in _InventoryServiceTest_. For example:

    public class InventoryServiceTest {
        private InventoryService inventoryService = new MyAwesomeInventoryService();
    }

### 3. Exercise 2 - Implementation of _ShopService_

* Create new class - _ShopService_
* Add price attribute to the _Product_ class
* Create method that accept _List_ of products and return total price

### 4. Bonus exercise - Create tests for ShopService