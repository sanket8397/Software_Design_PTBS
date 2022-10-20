# Software_Design_PTBS
## SER 515 - Fall 2022
Design Patterns implemented:
### 1. Facade Pattern
    Class: Facade
    File: Facade.java
    Facade is used for encapsulating a complex system into one single object.
    Facade is instantiated in Main.java file.
### 2. Bridge Pattern
    Class: 
    File:
    Class:
    File:
### 3. Factory Pattern
    Interface: ProductMenu
    File: ProductMenu.java
    Use: Commom=n Menu interface
    Class: ProduceProductMenu
    File: ProduceProductMenu.java
    Use: Concrete implementation of Produce menu
    Class: MeatProductMenu
    File: MeatProductMenu.java
    Use: Concrete Implementation of Meat Menu
    Abstract Class: Person
    File: Person.java
    Use: Creator class which declares method that creates new factory objects
    Buyer and Seller class: 
    CreateProductMenu method creates new factory objects of MeatProductMenu or ProduceProductMenu depending on product category.
### 4. Iterator Pattern
    Class: ProductIterator
    File: ProductIterator.java
    Use: Implemented to traverse products without exposing underlying representation.
    Class: OfferingIterator
    File: OfferingIterator.java
    Use: Implemented to traverse products without exposing underlying representation.
    Used in ClassProductList.java to traverse through products in accept method.
### 5. Visitor Pattern
    Class: NodeVisitor (Visitor Interface)
    File: NodeVisitor.java
    Use: Abstract class which has declared visiting methods
    Class: ReminderVisitor (Concrete Visitor)
    File: ReminderVisitor.java
    Use: Implement methods declared in NodeVisitor for all visitors. Different versions of same behavior for each visitor
    Used in: Facade, Trading, ClassProduct in accept method. (Same behavior is implemented in all 3 classes instances)
    For tesing added in run method of Facade.java.

### 6. Singleton Pattern
    Class: Facade
    File: Facade.java
    As we need only single instance of Facade.
    It can be used this to pass attributes of Facade class to other classes.
    Used in Main.java file.