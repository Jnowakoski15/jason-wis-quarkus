package net.nowakoski;

import jakarta.inject.Singleton;

@Singleton
public class HealthService {

    private boolean status = true;

    public void setStatusDown() {
        status = false;
    }

    public boolean isUp() {
        return status;
    }

}
