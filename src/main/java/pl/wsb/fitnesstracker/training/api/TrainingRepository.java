package pl.wsb.fitnesstracker.training.api;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAllByUserIdAndStartTimeAfter(Long userId, LocalDateTime startTime);

    long countByUserId(Long userId);
}
