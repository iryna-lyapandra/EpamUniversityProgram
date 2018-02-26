package gym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessProgram{
    ExerciseManager manager;
    private List <Exercise> programExercises;
    public FitnessProgram(ExerciseManager manager) {
        this.manager = manager;
        this.programExercises = new ArrayList<>();
    }



    public void addExcercisesByPurpose(String purpose){
        programExercises.addAll(manager.generateExcercisesByPurpose(purpose));
    }

    public void sortExercisesByTimeDesc(){
        manager.sortExcercisesByTimeDesc(programExercises);
    }
    public void displayNeededEquipment (){
        manager.displayEquipment(programExercises);
    }

}
