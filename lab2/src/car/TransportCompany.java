package car;

import java.util.ArrayList;
import java.util.List;

//composite structural design pattern
public class TransportCompany implements Transport {

    private List<Transport> transportList = new ArrayList<>();

    @Override
    public void manufacture() {
        transportList.forEach(t -> t.manufacture());
    }

    public void add (Transport transport){
        this.transportList.add(transport);
    }

    public void remove (Transport transport){
        this.transportList.remove(transport);
    }

    public void clear(){
        this.transportList.clear();
    }
}
