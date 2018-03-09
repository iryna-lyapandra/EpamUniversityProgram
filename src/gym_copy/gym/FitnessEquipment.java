package gym_copy.gym;

import java.util.List;

public interface FitnessEquipment {
    List<Exercise> getAllExercises();
    List <Exercise> getExercisesByPurpose(String purpose);


}
