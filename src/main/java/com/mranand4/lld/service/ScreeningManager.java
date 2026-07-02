package com.mranand4.lld.service;

import com.mranand4.lld.model.Movie;
import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Room;
import com.mranand4.lld.model.cinema.Seat;
import com.mranand4.lld.model.order.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningManager {

    private Map<Movie, List<Screening>> screeningsByMovie;
    private Map<Screening, List<Ticket>> ticketsByScreening;

    public ScreeningManager() {
        this.screeningsByMovie = new HashMap<>();
        this.ticketsByScreening = new HashMap<>();
    }

    public void addScreening(Movie movie, Screening screening) {
        screeningsByMovie
                .computeIfAbsent(movie, k -> new ArrayList<>())
                .add(screening);
    }

    public void addTicket(Screening screening, Ticket ticket) {
        ticketsByScreening
                .computeIfAbsent(screening, k -> new ArrayList<>())
                .add(ticket);
    }

    public List<Screening> getScreeningsForMovie(Movie movie) {
        return screeningsByMovie.getOrDefault(movie, new ArrayList<>());
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return ticketsByScreening.getOrDefault(screening, new ArrayList<>());
    }

    // available seats = all seats - booked seats
    public List<Seat> getAvailableSeats(Screening screening) {

        List<Seat> allSeats = screening.getRoom().getLayout().getAllSeats();
        List<Seat> bookedSeats =
                getTicketsForScreening(screening)
                    .stream().map(Ticket::getSeat).toList();

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        for(Seat seat : bookedSeats) {
            availableSeats.remove(seat);
        }

        return availableSeats;
    }


}
