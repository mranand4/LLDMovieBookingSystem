package com.mranand4.lld.service;

import com.mranand4.lld.model.Movie;
import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Seat;

import java.util.List;

public interface MovieBookingSystem {

    void bookTicket(Screening screening, Seat seat);
    void addScreening(Movie movie, Screening screening);
    List<Screening> getScreeningsForMovie(Movie movie);
    List<Seat> getAvailableSeats(Screening screening);

}
