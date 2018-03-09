package gym_copy.gym;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill();
        Barbell barbell = new Barbell();

        Exercise jogging = new Exercise("jogging", 20, "burning fat", "Set speed to 8 km/h", treadmill );
        Exercise sprinting = new Exercise("sprinting", 10, "burning fat", "Set speed to 15 km/h", treadmill);
        Exercise climbingUp = new Exercise("climbing up", 25, "burning fat", "Set speed to 6 km/h and incline to 5 degrees", treadmill);
        Exercise bicepsEx = new Exercise("biceps exercise", 3, "building muscles", "Lift barbel with your biceps during 3 mins", barbell);
        Exercise squatsWithBarbell = new Exercise("squats with barbell", 12, "building muscles", "Squat with the barbell", barbell );

        treadmill.addExercises(jogging);
        treadmill.addExercises(sprinting);
        treadmill.addExercises(climbingUp);
        barbell.addExercises(bicepsEx);
        barbell.addExercises(squatsWithBarbell);

        List allEquipment = new ArrayList();
        allEquipment.add(treadmill);
        allEquipment.add(barbell);
        ExerciseManager manager = new ExerciseManager(allEquipment);

        FitnessProgram fitnessProgram = new FitnessProgram(manager);
        fitnessProgram.addExcercisesByPurpose("burning fat");
        fitnessProgram.addExcercisesByPurpose("building muscles");
        System.out.println("Fitness program before sorting by time");
        fitnessProgram.displayNeededEquipment();
        fitnessProgram.sortExercisesByTimeDesc();
        System.out.println("\nFitness program after sorting by time");
        fitnessProgram.displayNeededEquipment();

    }
}
