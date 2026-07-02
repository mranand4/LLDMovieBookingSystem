package com.mranand4.lld.model.cinema;

import com.mranand4.lld.model.pricing.PricingStrategy;

import java.math.BigDecimal;
import java.util.UUID;

public class Seat {

    private String id;
    private String seatNumber;
    private PricingStrategy pricingStrategy;

    public Seat(String number, PricingStrategy pricingStrategy) {
        this.seatNumber = number;
        this.pricingStrategy = pricingStrategy;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public BigDecimal getPrice() {
        return pricingStrategy.getPrice();
    }
}
