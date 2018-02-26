package gym.excercises;

import gym.equipment.FitnessEquipment;
import gym.excercises.BurningFatExercise;

public class Jogging extends BurningFatExercise {
    public Jogging(int minutesToComplete, FitnessEquipment fitnessEquipment) {
        super("jogging", minutesToComplete, fitnessEquipment);
    }
}
