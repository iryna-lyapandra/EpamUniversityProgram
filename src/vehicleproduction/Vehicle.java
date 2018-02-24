package vehicleproduction;

public abstract class Vehicle {
IEngine engine;
ITransmission transmission;

    public Vehicle(IEngine engine, ITransmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }
    void startEngine(){
        engine.startEngine();
    }
    void stopEngine(){
        engine.stopEngine();
    }
    void getTransmissionInfo(){
        transmission.getInfo();
    }




}
