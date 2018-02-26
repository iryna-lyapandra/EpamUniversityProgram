package gym.excercises;

import gym.equipment.FitnessEquipment;
import gym.excercises.BurningFatExercise;

public class Sprinting extends BurningFatExercise {
    public Sprinting(int minutesToComplete, FitnessEquipment fitnessEquipment) {
        super("sprinting", minutesToComplete, fitnessEquipment);
    }
}
