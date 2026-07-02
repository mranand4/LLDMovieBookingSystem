package com.mranand4.lld.model;

import java.time.Duration;
import java.util.UUID;

public class Movie {

    private String id;
    private String title;
    private int durationInMinutes;

    // id is set at time of object creation and cannot be changed
    public Movie(String title, int durationInMinutes) {
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Duration getDuration() {
        return Duration.ofMinutes(durationInMinutes);
    }
}
