
import car.*;

public class Main {

    public static void main(String[] args) {


        Transport bmw = VehicleFactory.getVehicle(VehicleBrand.CAR_BMW);
        Transport mercedes = VehicleFactory.getVehicle(VehicleBrand.CAR_MERCEDES);
        Transport mercedesSport = new SportTransport(mercedes);

        TargetInterface transportCompany = new TransportCompanyAdapter();
        transportCompany.addOneTransport(bmw);
        transportCompany.addOneTransport(mercedes);
        transportCompany.addOneTransport(mercedesSport);

        transportCompany.createTransports();

    }

}