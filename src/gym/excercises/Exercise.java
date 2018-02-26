package gym.excercises;

import gym.equipment.FitnessEquipment;

public interface Exercise extends Comparable{
        String getName();
        int getMinutesToComplete();
        String getPurpose();
        FitnessEquipment getFitnessEquipment();

        @Override
        public int compareTo(Object toCompare);
    }
