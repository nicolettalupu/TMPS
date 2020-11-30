package car;


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
    public void add(Transport transport) {

    }

    @Override
    public void remove(Transport transport) {

    }

    @Override
    public void clear() {

    }
}
