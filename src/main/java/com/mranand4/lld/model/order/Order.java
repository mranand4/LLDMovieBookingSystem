package com.mranand4.lld.model.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private String id;
    private List<Ticket> tickets;
    private LocalDateTime orderDate;

    public Order(List<Ticket> tickets, LocalDateTime orderDate) {
        this.tickets = tickets;
        this.orderDate = orderDate;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return tickets
                .stream()
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", tickets=" + tickets +
                ", orderDate=" + orderDate +
                '}';
    }
}
