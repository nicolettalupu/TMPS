package car;

//adapter structural design pattern
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
