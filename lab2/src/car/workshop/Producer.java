package car.workshop;

public class Producer implements Workshop {
    @Override
    public void work() {
        System.out.println("Produced");
    }
}
