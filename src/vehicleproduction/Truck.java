package vehicleproduction;

public class Truck extends Vehicle {
    public Truck(IEngine engine, ITransmission transmission) {
        super(engine, transmission);
        System.out.println("Constructed a truck");
    }
}
