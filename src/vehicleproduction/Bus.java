package vehicleproduction;

public class Bus extends Vehicle {
    public Bus(IEngine engine, ITransmission transmission) {
        super(engine, transmission);
        System.out.println("Constructed a bus");
    }
}
