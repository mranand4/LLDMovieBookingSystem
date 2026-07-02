package com.mranand4.lld;

import com.mranand4.lld.model.Movie;
import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Cinema;
import com.mranand4.lld.model.cinema.Layout;
import com.mranand4.lld.model.cinema.Room;
import com.mranand4.lld.model.cinema.Seat;
import com.mranand4.lld.model.pricing.NormalPrice;
import com.mranand4.lld.model.pricing.PremiumPrice;
import com.mranand4.lld.service.MovieBookingSystem;
import com.mranand4.lld.service.SimpleMovieBookingSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static Room createNewRoom() {
        Seat normalSeat = new Seat(String.valueOf((int)(Math.random() * 1_000_000)),
                new NormalPrice(BigDecimal.valueOf(5)));
        Seat premiumSeat = new Seat(String.valueOf((int)(Math.random() * 1_000_000)),
                new PremiumPrice(BigDecimal.valueOf(11)));

        Layout layout = new Layout(2, 2);
        layout.addSeat(0, 0, premiumSeat.getSeatNumber(), premiumSeat);
        layout.addSeat(1, 1, normalSeat.getSeatNumber(), normalSeat);

        Room room = new Room("Room - " + (int)(Math.random() * 100), layout);

        return room;
    }

    public static void main(String[] args) {

        MovieBookingSystem mbs = new SimpleMovieBookingSystem();

        Movie movie1 = new Movie("Lord Of The Rings 1", 178);
        Movie movie2 = new Movie("Shrek", 90);

        Room room1 = createNewRoom();
        Room room2 = createNewRoom();
        Cinema cinema1 = new Cinema("Cinema 1", "Address 1", List.of(room1, room2));

        Room room3 = createNewRoom();
        Room room4 = createNewRoom();
        Cinema cinema2 = new Cinema("Cinema 2", "Address 2", List.of(room3, room4));

        Screening movie1Screening1 = new Screening(movie1, room1, cinema1,
                LocalDateTime.of(2026, 6, 4, 1, 0),
                LocalDateTime.of(2026, 6, 4, 4, 0));

        Screening movie1Screening2 = new Screening(movie1, room2, cinema1,
                LocalDateTime.of(2026, 6, 4, 1, 0),
                LocalDateTime.of(2026, 6, 4, 4, 0));

        Screening movie1Screening3 = new Screening(movie1, room1, cinema1,
                LocalDateTime.of(2026, 6, 4, 5, 0),
                LocalDateTime.of(2026, 6, 4, 8, 0));

        Screening movie2Screening1 = new Screening(movie2, room1, cinema1,
                LocalDateTime.of(2026, 6, 4, 9, 0),
                LocalDateTime.of(2026, 6, 4, 11, 0));

        Screening movie2Screening2 = new Screening(movie2, room3, cinema2,
                LocalDateTime.of(2026, 6, 4, 1, 0),
                LocalDateTime.of(2026, 6, 4, 3, 0));

        mbs.addScreening(movie1, movie1Screening1);
        mbs.addScreening(movie1, movie1Screening2);
        mbs.addScreening(movie1, movie1Screening3);
        mbs.addScreening(movie2, movie2Screening1);
        mbs.addScreening(movie2, movie2Screening2);

        // list screenings for LOTR 1
        System.out.println("Screenings For LOTR 1");
        mbs.getScreeningsForMovie(movie1).forEach(System.out::println);

        System.out.println();

        // list screenings for Shrek
        System.out.println("Screenings For Shrek");
        mbs.getScreeningsForMovie(movie2).forEach(System.out::println);

        System.out.println();

        // list available seats for lotr 1
        System.out.println("Available Seats For LOTR 1 In Screening 1");
        System.out.println(mbs.getAvailableSeats(movie1Screening1));

        // booking 1 seat in screening 1
        mbs.bookTicket(movie1Screening1, mbs.getAvailableSeats(movie1Screening1).getFirst());

        // list available seats for lotr 1
        System.out.println("Available Seats For LOTR 1 In Screening 1 After Someone Booked 1 Seat");
        System.out.println(mbs.getAvailableSeats(movie1Screening1));

    }
}
