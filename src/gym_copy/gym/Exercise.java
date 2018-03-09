package gym_copy.gym;

public class Exercise implements Comparable {
    private String name;
    private int minutesToComplete;
    private String purpose;
    private String description;
    private FitnessEquipment fitnessEquipment;

    public Exercise(String name, int minutesToComplete, String purpose, String description, FitnessEquipment fitnessEquipment) {
        this.name = name;
        this.minutesToComplete = minutesToComplete;
        this.purpose = purpose;
        this.description = description;
        this.fitnessEquipment = fitnessEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutesToComplete() {
        return minutesToComplete;
    }

    public void setMinutesToComplete(int minutesToComplete) {
        this.minutesToComplete = minutesToComplete;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FitnessEquipment getFitnessEquipment() {
        return fitnessEquipment;
    }

    public void setFitnessEquipment(FitnessEquipment fitnessEquipment) {
        this.fitnessEquipment = fitnessEquipment;
    }

    public void displayInfo(){
        System.out.println(getName());
        System.out.println("Purpose of the exercise: " + getPurpose());
        System.out.println("Time needed: " + getMinutesToComplete() + " minutes");
        System.out.println("Guidelines " + getDescription());
    }

    @Override
    public int compareTo(Object toCompare) {
        int compareTime = ((Exercise)toCompare).getMinutesToComplete();
        return compareTime - this.getMinutesToComplete();
    }
}
