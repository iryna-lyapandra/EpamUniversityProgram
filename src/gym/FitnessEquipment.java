package gym;

import java.util.ArrayList;
import java.util.List;

public interface FitnessEquipment {
    public void addExercises(Exercise exerciseToAdd);

    public List<Exercise> getAllExercises();

    //get all of the exercises available on a certain equipment that meet certain criteria
    public List <Exercise> getExercisesByPurpose(String purpose);
}
