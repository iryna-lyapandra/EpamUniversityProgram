package vehicleproduction;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(new ElectricEngine(), new AutomaticTransmission());
        car.startEngine();
        car.getTransmissionInfo();
        Vehicle bus = new Bus(new PetrolEngine(), new ManualTransmission());
        bus.startEngine();
        bus.getTransmissionInfo();

    }
}
