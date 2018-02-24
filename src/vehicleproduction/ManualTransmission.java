package vehicleproduction;

public class ManualTransmission implements ITransmission {
    @Override
    public void getInfo() {
        System.out.println("Using manual transmission");
    }
}
