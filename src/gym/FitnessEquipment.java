package gym;

import java.util.ArrayList;
import java.util.List;

public interface FitnessEquipment {
    List<Exercise> getAllExercises();
    List <Exercise> getExercisesByPurpose(String purpose);


}
