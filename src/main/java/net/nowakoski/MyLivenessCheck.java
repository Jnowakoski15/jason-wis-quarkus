package net.nowakoski;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import jakarta.inject.Inject;

@Liveness
public class MyLivenessCheck implements HealthCheck {

    @Inject
    HealthService service;

    @Override
    public HealthCheckResponse call() {
        if (service.isUp()) {
            return HealthCheckResponse.up("alive");
        }
        else {
            return HealthCheckResponse.down("alive");
        }
    }
}