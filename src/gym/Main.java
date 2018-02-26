package gym;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill();
        Barbell barbell = new Barbell();

        Exercise jogging = new Jogging(20, treadmill);
        Exercise sprinting = new Sprinting(10, treadmill);
        Exercise climbingUp = new ClimbingUp(25, treadmill);
        Exercise bicepsEx = new BicepsBarbellLift(3, barbell);
        Exercise squatsWithBarbell = new SquatsWithBarbell(12, barbell);

        treadmill.addExercises(jogging);
        treadmill.addExercises(sprinting);
        treadmill.addExercises(climbingUp);
        barbell.addExercises(bicepsEx);
        barbell.addExercises(squatsWithBarbell);

        List allEquipment = new ArrayList();
        allEquipment.add(treadmill);
        allEquipment.add(barbell);

        FitnessProgram fitnessProgram = new FitnessProgram(allEquipment);
        fitnessProgram.addExercisesByPurpose("burning fat");
        fitnessProgram.addExercisesByPurpose("building muscles");

        System.out.println("Fitness program BEFORE sorting by time");
        fitnessProgram.displayEquipment();
        fitnessProgram.sortExercisesByTimeDesc();
        System.out.println("\nFitness program AFTER sorting by time");
        fitnessProgram.displayEquipment();

    }
}
