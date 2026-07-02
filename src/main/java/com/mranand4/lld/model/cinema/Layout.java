package com.mranand4.lld.model.cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Layout {

    private int rows;
    private int columns;
    private Map<String, Seat> seatsByNumber;
    private Map<Integer, Map<Integer, Seat>> seatsByPosition;

    public Layout(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seatsByNumber = new HashMap<>();
        this.seatsByPosition = new HashMap<>();
    }

    public void addSeat(int row, int column, String seatNumber, Seat seat) {
        seatsByNumber.put(seatNumber, seat);
        seatsByPosition
                .computeIfAbsent(row, k -> new HashMap<>())
                .put(column, seat);
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(seatsByNumber.values());
    }

    public Seat getSeatByNumber(String seatNumber) {
        return seatsByNumber.get(seatNumber);
    }

    public Seat getSeatByPosition(int row, int column) {
        Map<Integer, Seat> columnMap = seatsByPosition.get(row);
        return columnMap != null ? columnMap.get(column) : null;
    }
}
