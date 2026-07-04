package com.mranand4.lld.service;

import com.mranand4.lld.model.Movie;
import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Seat;
import com.mranand4.lld.model.order.Ticket;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class PessimisticLockMovieBookingSystem implements MovieBookingSystem {

    private ScreeningManager screeningManager;
    private SeatLockManager seatLockManager;

    public PessimisticLockMovieBookingSystem() {
        this.screeningManager = new ScreeningManager();
        this.seatLockManager = new SeatLockManager(Duration.ofSeconds(30));
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
        if(!screeningManager.isSeatAvailable(screening, seat)) {
            System.out.println("Seat is already booked ...");
        }

        boolean lockSeat = seatLockManager.lockSeat(screening, seat);

        if(lockSeat) {
            BigDecimal price = seat.getPrice();
            Ticket ticket = new Ticket(screening, seat, price);
            screeningManager.addTicket(screening, ticket);
        } else {
            System.out.println("Seat not available at the moment, please try later ...");
        }
    }
}
