package gym;

import java.util.ArrayList;
import java.util.List;

public class Barbell implements FitnessEquipment {
    private String name;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public Barbell() {
        this.name = "barbell";
    }

    public void addExercises(Exercise exerciseToAdd) {
        exercises.add(exerciseToAdd);
    }

    @Override
    public List<Exercise> getAllExercises() {
        return exercises;
    }

    @Override
    public List <Exercise> getExercisesByPurpose(String purpose) {
        List <Exercise> result = new ArrayList<>();
        for (Exercise exercise : exercises){
            if (exercise.getPurpose().toLowerCase().equals(purpose.toLowerCase())){
                result.add(exercise);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
