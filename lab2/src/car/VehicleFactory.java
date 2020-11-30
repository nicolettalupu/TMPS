package car;

import car.workshop.Assembler;
import car.workshop.Producer;

import java.util.HashMap;

//flyweight structural design pattern
public class VehicleFactory {

    private static final HashMap<VehicleBrand,Vehicle> vehicles = new HashMap<>();

    public static Vehicle getVehicle(VehicleBrand vehicleBrand){

        Vehicle vehicle = vehicles.get(vehicleBrand);


        if( vehicle == null){
            switch (vehicleBrand){
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
            vehicles.put(vehicleBrand,vehicle);
        }


        return vehicle;
    }
}
