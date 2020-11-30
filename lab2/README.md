# Laboratory work nr.1 (Structural Design Patterns)
## Task: create a program in which you will use 5 Structural Design Patterns
#### During this laboratory work I used 5 Structural Design Pattern:
- Bridge
- Decorator
- Flyweight
- Adapter
- Composite

## Bridge Design Pattern
**Java Bridge Pattern** is one of the **Gangs of Four Design patterns** and comes in the **Structural Design Pattern** category.

#### About Bridge : 
According to GoF bridge design pattern is:
- Decouple an abstraction from its implementation so that the two can vary independently
- The implementation of bridge design pattern follows the notion to prefer  Composition over  inheritance.

 When we have interface hierarchies in both interfaces as well as implementations, then bridge design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client programs.

Notice the bridge between `Vehicle` and `Workshop` interfaces and use of composition in implementing the bridge pattern.

```java
//bridge structural design pattern  
public abstract class Vehicle implements Transport {

 protected VehicleBrand vehicleBrand;
 protected Workshop producer;
 protected Workshop assembler;

 public Vehicle(VehicleBrand vehicleBrand, Workshop producer, Workshop assembler) {
  this.vehicleBrand = vehicleBrand;
  this.producer = producer;
  this.assembler = assembler;
 }

 public VehicleBrand getVehicleBrand() {
  return vehicleBrand;
 }

 @Override
 public void add(Transport transport) {}

 @Override
 public void remove(Transport transport) {}

 @Override
 public void clear() {}
}
```
Bridge design pattern can be used when both abstraction and implementation can have different hierarchies independently and we want to hide the implementation from the client application.

## Decorator Design Pattern

**Java Decorator Pattern** is one of the **Gangs of Four Design patterns** and comes in the **Structural Design Pattern** category.

#### About Decorator: 

We use inheritance or composition to extend the behavior of an object but this is done at compile time and its applicable to all the instances of the class. We can’t add any new functionality of remove any existing behavior at runtime – this is when Decorator pattern comes.
Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances of the same class will not be affected by this, so individual object gets the modified behavior. 

We need to have following types to implement decorator design pattern.

1.  **Component Interface**  – The interface or  **abstract class**  defining the methods that will be implemented. In our case  `Transport`  will be the component interface.

```java
public interface Transport {  
    public void manufacture();  
    
 public void add(Transport transport);  
 public void remove(Transport transport);  
 public void clear();  
  
}
```

2. **Component Implementation** – The basic implementation of the component interface. We can have `Car` class as our component implementation.

```java
//decorator structural design pattern
public class Car extends Vehicle {

    public Car(VehicleBrand vehicleBrand, Workshop producer, Workshop assembler) {
        super(vehicleBrand, producer, assembler);
    }

    @Override
    public void manufacture() {
        System.out.println("------- CAR -------");
        System.out.println("Car " + this.vehicleBrand);
        producer.work();
        assembler.work();
    }
}
```

3. **Decorator** – Decorator class implements the component interface and it has a HAS-A relationship with the component interface. The component variable should be accessible to the child decorator classes, so we will make this variable protected.

```java
//decorator design pattern
public class TransportDecorator implements Transport {
 protected Transport transport;

 public TransportDecorator(Transport transport) {
  this.transport = transport;
 }

 @Override
 public void manufacture() {
  this.transport.manufacture();
 }

 @Override
 public void add(Transport transport) {}

 @Override
 public void remove(Transport transport) {}

 @Override
 public void clear() {}
}
```

4. **Concrete Decorators** – Extending the base decorator functionality and modifying the component behavior accordingly. We can have concrete decorator classes as `SportTransport`.



```java
//decorator structural design pattern  
public class SportTransport extends TransportDecorator {

    public SportTransport(Transport transport) {
        super(transport);
    }
    @Override
    public void manufacture() {
        super.manufacture();
        System.out.println("Adding features of Sport Transport");
    }
}
```

#### Decorator Design Pattern – Important Points

-   Decorator design pattern is helpful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the number of choices are more.
-   The disadvantage of decorator design pattern is that it uses a lot of similar kind of objects (decorators).
-   Decorator pattern is used a lot in  Java IO  classes, such as FileReader, BufferedReader etc.



## Flyweight Design Pattern
**Java Flyweight Pattern** is one of the **Gangs of Four Design patterns** and comes in the **Structural Design Pattern** category.

#### About Flyweight: 
According to GoF,  **flyweight design pattern**  intent is: "Use sharing to support large numbers of fine-grained objects efficiently".

Flyweight design pattern is used when we need to create a lot of Objects of a class. Since every object consumes memory space that can be crucial for low memory devices, such as mobile devices or embedded systems, flyweight design pattern can be applied to reduce the load on memory by sharing objects.

To apply flyweight pattern, we need to divide Object property into **intrinsic** and **extrinsic** properties. Intrinsic properties make the Object unique whereas extrinsic properties are set by client code and used to perform different operations. For example, an Object Circle can have extrinsic properties such as color and width.

For applying flyweight pattern, we need to create a **Flyweight factory** that returns the shared objects. For my example, I used abstract class `Vehicle` and classes which extends it as `Car` and `Bike`. Car and Bike have `protected VehicleBrand vehicleBrand;` as **intrinsic** property .


The flyweight factory will be used by client programs to instantiate the Object, so we need to keep a map of Objects in the factory that should not be accessible by client application.

Whenever client program makes a call to get an instance of Object, it should be returned from the HashMap, if not found then create a new Object and put in the Map and then return it. We need to make sure that all the intrinsic properties are considered while creating the Object.
```java
//flyweight structural design pattern
//Flyweight factory
public class VehicleFactory {

    private static final HashMap < VehicleBrand, Vehicle > vehicles = new HashMap < > ();

    public static Vehicle getVehicle(VehicleBrand vehicleBrand) {

        Vehicle vehicle = vehicles.get(vehicleBrand);

        if (vehicle == null) {
            switch (vehicleBrand) {
                case CAR_BMW:
                    vehicle = new Car(VehicleBrand.CAR_BMW, new Producer(), new Assembler());
                    break;
                case CAR_MERCEDES:
                    vehicle = new Car(VehicleBrand.CAR_MERCEDES, new Producer(), new Assembler());
                    break;
                case BIKE_DUCATI:
                    vehicle = new Car(VehicleBrand.BIKE_DUCATI, new Producer(), new Assembler());
                    break;
                case BIKE_KAWASAKI:
                    vehicle = new Car(VehicleBrand.BIKE_KAWASAKI, new Producer(), new Assembler());
                    break;
            }
            vehicles.put(vehicleBrand, vehicle);
        }

        return vehicle;
    }
}
```
```java
public class Car extends Vehicle {
    public Car(VehicleBrand vehicleBrand, Workshop producer, Workshop assembler) {
        super(vehicleBrand, producer, assembler);
    }
    @Override
    public void manufacture() {
        System.out.println("------- CAR -------");
        System.out.println("Car " + this.vehicleBrand);
        producer.work();
        assembler.work();
    }
}
```
```java
public class Bike extends Vehicle {
    public Bike(VehicleBrand vehicleBrand, Workshop producer, Workshop assembler) {
        super(vehicleBrand, producer, assembler);
    }

    @Override
    public void manufacture() {
        System.out.println("------- BIKE -------");
        System.out.println("Bike " + this.vehicleBrand);
        producer.work();
        assembler.work();
    }
}
```

### Flyweight Design Pattern Important Points

1.  In our example, the client code is not forced to create object using Flyweight factory but we can force that to make sure client code uses flyweight pattern implementation but its a complete design decision for particular application.
2.  Flyweight pattern introduces complexity and if number of shared objects are huge then there is a trade of between memory and time, so we need to use it judiciously based on our requirements.
3.  Flyweight pattern implementation is not useful when the number of intrinsic properties of Object is huge, making implementation of Factory class complex.


## Adapter Design Pattern
**Java Adapter Pattern** is one of the **Gangs of Four Design patterns** and comes in the **Structural Design Pattern** category.

#### About Adapter: 
Adapter design pattern is one of the **structural design pattern** and its used so that two unrelated interfaces can work together. The object that joins these unrelated interface is called an **Adapter**.

#### Two Way Adapter Pattern

While implementing Adapter pattern, there are two approaches – class adapter and object adapter – however both these approaches produce same result.

1.  **Class Adapter**  – This form uses  **java inheritance** and extends the source interface, in our case Socket class.
2.  **Object Adapter**  – This form uses  **Java Composition** and adapter contains the source object.

I used  **Class Adapter** implementation.



```java
public interface TargetInterface {
    public void createTransports();
    public void addOneTransport(Transport transport);
    public void removeOneTransport(Transport transport);
    public void destroyAllTransports();
}
```

```java
public class TransportCompany implements Transport {

    private List < Transport > transportList = new ArrayList < > ();

    @Override
    public void manufacture() {
        transportList.forEach(t - > t.manufacture());
    }

    public void add(Transport transport) {
        this.transportList.add(transport);
    }

    public void remove(Transport transport) {
        this.transportList.remove(transport);
    }

    public void clear() {
        this.transportList.clear();
    }
}
```

```java
public class TransportCompanyAdapter extends TransportCompany implements TargetInterface {


    @Override
    public void createTransports() {
        manufacture();
    }

    @Override
    public void addOneTransport(Transport transport) {
        add(transport);
    }

    @Override
    public void removeOneTransport(Transport transport) {
        remove(transport);
    }

    @Override
    public void destroyAllTransports() {
        clear();
    }
}
```



## Composite Design Pattern

**Java Composite Pattern** is one of the **Gangs of Four Design patterns** and comes in the **Structural Design Pattern** category.

#### About Composite: 

Composite pattern is one of the Structural design pattern. Composite design pattern is used when we have to represent a part-whole hierarchy.
When we need to create a structure in a way that the objects in the structure has to be treated the same way, we can apply composite design pattern.


####  Composite object
```java
public class TransportCompany implements Transport {

    private List < Transport > transportList = new ArrayList < > ();

    @Override
    public void manufacture() {
        transportList.forEach(t - > t.manufacture());
    }

    public void add(Transport transport) {
        this.transportList.add(transport);
    }

    public void remove(Transport transport) {
        this.transportList.remove(transport);
    }

    public void clear() {
        this.transportList.clear();
    }
}
```

```java
//bridge structural design pattern  
public interface Workshop {  
    public void work();  
}
```

