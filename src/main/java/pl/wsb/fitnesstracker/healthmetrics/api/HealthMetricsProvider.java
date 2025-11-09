package pl.wsb.fitnesstracker.healthmetrics.api;

import pl.wsb.fitnesstracker.statistics.api.Statistics;

import java.util.Optional;

public interface HealthMetricsProvider {
    /**
     * Retrieves a health metrics based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param healthMetricId id of the health metrics to be searched
     * @return An {@link Optional} containing the located HealthMetrics, or {@link Optional#empty()} if not found
     */
    Optional<Statistics> getHealthMetrics(Long healthMetricId);
}
