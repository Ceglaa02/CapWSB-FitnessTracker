package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class WorkoutSessionRepository {
    @PersistenceContext
    private EntityManager em;

    public void saveWorkoutSessionRepository(WorkoutSession workoutSession) {
        this.em.persist(workoutSession);
    }
}
