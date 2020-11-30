package car;

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
