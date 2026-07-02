package com.mranand4.lld.model;

import com.mranand4.lld.model.cinema.Cinema;
import com.mranand4.lld.model.cinema.Room;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Screening {

    private String id;
    private Movie movie;
    private Room room;
    private Cinema cinema;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Screening(Movie movie, Room room, Cinema cinema, LocalDateTime startTime, LocalDateTime endTime) {
        this.movie = movie;
        this.room = room;
        this.cinema = cinema;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }
}
