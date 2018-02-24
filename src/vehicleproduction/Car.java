package vehicleproduction;

public class Car extends Vehicle {
    public Car(IEngine engine, ITransmission transmission) {
        super(engine, transmission);
        System.out.println("Constructed a car");
    }
}
