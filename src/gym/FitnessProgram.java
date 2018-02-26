package gym;

import gym.equipment.FitnessEquipment;
import gym.excercises.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessProgram{
    private List <Exercise> programExercises;
    private List<FitnessEquipment> allEquipment = new ArrayList<>();

    public FitnessProgram(List<FitnessEquipment> allEquipment) {
        this.allEquipment = allEquipment;
        this.programExercises = new ArrayList<>();
    }

    public void addExercisesByPurpose(String purpose){
        for (FitnessEquipment singleEquipment : allEquipment){
            programExercises.addAll(singleEquipment.getExercisesByPurpose(purpose));
        }
    }

    public void displayEquipment (){
        for (Exercise e : programExercises){
            System.out.println(e.getFitnessEquipment() + ": " + e.getName() + " " + e.getMinutesToComplete() + " minutes");
        }
    }

    public void sortExercisesByTimeDesc(){
        Collections.sort(programExercises);
    }

    public List<FitnessEquipment> getAllEquipment() {
        return allEquipment;
    }

    public void setAllEquipment(List<FitnessEquipment> allEquipment) {
        this.allEquipment = allEquipment;
    }
}
