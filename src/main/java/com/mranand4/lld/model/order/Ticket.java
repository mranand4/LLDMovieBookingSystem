package com.mranand4.lld.model.order;

import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Seat;

import java.math.BigDecimal;
import java.util.UUID;

public class Ticket {

    private String id;
    private Screening screening;
    private Seat seat;
    private BigDecimal price;

    public Ticket(Screening screening, Seat seat, BigDecimal price) {
        this.screening = screening;
        this.seat = seat;
        this.price = price;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
