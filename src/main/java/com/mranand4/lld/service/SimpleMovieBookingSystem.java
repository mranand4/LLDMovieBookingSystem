package com.mranand4.lld.service;

import com.mranand4.lld.model.Movie;
import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Cinema;
import com.mranand4.lld.model.cinema.Seat;
import com.mranand4.lld.model.order.Ticket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimpleMovieBookingSystem implements MovieBookingSystem {

    private ScreeningManager screeningManager;

    public SimpleMovieBookingSystem() {
        this.screeningManager = new ScreeningManager();
    }

    @Override
    public void addScreening(Movie movie, Screening screening) {
        screeningManager.addScreening(movie, screening);
    }

    @Override
    public List<Screening> getScreeningsForMovie(Movie movie) {
        return screeningManager.getScreeningsForMovie(movie);
    }

    @Override
    public List<Seat> getAvailableSeats(Screening screening) {
        return screeningManager.getAvailableSeats(screening);
    }

    @Override
    public void bookTicket(Screening screening, Seat seat) {
        BigDecimal price = seat.getPrice();
        Ticket ticket = new Ticket(screening, seat, price);
        screeningManager.addTicket(screening, ticket);
    }
}
