package vehicleproduction;

public class DieselEngine implements IEngine{
    boolean isStared;
    @Override
    public void startEngine() {
        if (! isStared){
            System.out.println("Starting the diesel engine");
        }
        else{
            System.out.println("The engine is already started");
        }
    }

    @Override
    public void stopEngine() {
        if (isStared){
            System.out.println("Stopping the diesel engine");
        }
        else{
            System.out.println("The engine is already stopped");
        }
    }
}
