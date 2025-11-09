package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.persistence.*;
import lombok.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name = "Health_Metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class HealthMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private float height;

    @Column(name = "heartRate")
    private int heartRate;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public HealthMetrics(
            final LocalDate date,
            final float weight,
            final float height,
            final int heartRate) {
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }

}
