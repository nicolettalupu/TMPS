package car;

//adapter structural design pattern
public interface TargetInterface {

    public void createTransports();

    public void addOneTransport(Transport transport);

    public void removeOneTransport(Transport transport);

    public void destroyAllTransports();
}
