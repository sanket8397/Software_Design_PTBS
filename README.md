# Software_Design_PTBS
Design Patterns implemented:
### 1. Facade Pattern
    Class Name: Facade
    File name: Facade.java
    Facade is used for encapsulating a complex system into one single object.
### 2. Bridge Pattern
### 3. Factory Pattern
### 4. Iterator Pattern
    Class: ProductIterator
    File: ProductIterator.java
    Use: Implemented to traverse products without exposing underlying representation.
    Class: OfferingIterator
    File: OfferingIterator.java
    Use: Implemented to traverse products without exposing underlying representation.
### 5. Visitor Pattern
    Class: NodeVisitor (Visitor Interface)
    File: NodeVisitor.java
    Use: Abstract class which has declared visiting methods
    Class: ReminderVisitor (Concrete Visitor)
    File: ReminderVisitor.java
    Use: Implement methods declared in NodeVisitor for all visitors. Different versions of same behavior for each visitor
    Used in: Facade, Trading, ClassProduct in accept method. (Same behavior is implemented in all 3 classes instances)

### 6. Singleton Pattern
    Class Name: Facade
    File Name: Facade.java
    As we need only single instance of Facade.
    It can be used this to pass attributes of Facade class to other classes.
    Used in Main.java file.