package gym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseManager {
    private List<FitnessEquipment> allEquipment = new ArrayList<>();

    public ExerciseManager(List<FitnessEquipment> allEquipment) {
        this.allEquipment = allEquipment;
    }

    public List <Exercise> generateExcercisesByPurpose(String purpose){
        List <Exercise> result = new ArrayList<>();
        for (FitnessEquipment singleEquipment : allEquipment){
            result.addAll(singleEquipment.getExercisesByPurpose(purpose));
        }
        return result;
    }
    public void displayEquipment (List<Exercise> programExercises){
        for (Exercise e : programExercises){
            System.out.println(e.getFitnessEquipment() + ": " + e.getName() + " " + e.getMinutesToComplete() + " minutes");
        }
    }
    public List sortExcercisesByTimeDesc(List <Exercise> programExercises){
        Collections.sort(programExercises);
        return programExercises;
    }

    public List<FitnessEquipment> getAllEquipment() {
        return allEquipment;
    }

    public void setAllEquipment(List<FitnessEquipment> allEquipment) {
        this.allEquipment = allEquipment;
    }
}
