package vehicleproduction;

public class ElectricEngine implements IEngine {
    boolean isStared;
    @Override
    public void startEngine() {
        if (! isStared){
            System.out.println("Starting the electric engine");
        }
        else{
            System.out.println("The engine is already started");
        }
    }

    @Override
    public void stopEngine() {
        if (isStared){
            System.out.println("Stopping the electric engine");
        }
        else{
            System.out.println("The engine is already stopped");
        }
    }
}
