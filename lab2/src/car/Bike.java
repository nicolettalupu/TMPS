package car;

import car.workshop.Workshop;

//bridge structural design pattern
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
