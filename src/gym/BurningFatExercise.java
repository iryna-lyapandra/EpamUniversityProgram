package gym;

public abstract class BurningFatExercise implements Exercise {
    private String name;
    private int minutesToComplete;
    private String purpose;
    private FitnessEquipment fitnessEquipment;

    public BurningFatExercise(String name, int minutesToComplete, FitnessEquipment fitnessEquipment) {
        this.name = name;
        this.minutesToComplete = minutesToComplete;
        this.purpose = "burning fat";
        this.fitnessEquipment = fitnessEquipment;
    }

    public String getName() {
        return name;
    }

    public int getMinutesToComplete() {
        return minutesToComplete;
    }

    public String getPurpose() {
        return purpose;
    }

    public FitnessEquipment getFitnessEquipment() {
        return fitnessEquipment;
    }

    public void setFitnessEquipment(FitnessEquipment fitnessEquipment) {
        this.fitnessEquipment = fitnessEquipment;
    }

    @Override
    public int compareTo(Object toCompare) {
        int compareTime = ((Exercise)toCompare).getMinutesToComplete();
        return compareTime - this.getMinutesToComplete();
    }
}
