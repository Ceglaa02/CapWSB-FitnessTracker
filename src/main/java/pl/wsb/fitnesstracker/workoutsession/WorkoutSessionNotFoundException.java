package pl.wsb.fitnesstracker.workoutsession;

public class WorkoutSessionNotFoundException extends RuntimeException {
    public WorkoutSessionNotFoundException(String message) {
        super(message);
    }
}
