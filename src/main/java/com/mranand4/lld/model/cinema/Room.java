package com.mranand4.lld.model.cinema;

import java.util.UUID;

public class Room {

    private String id;
    private String roomNumber;
    private Layout layout;

    public Room(String roomNumber, Layout layout) {
        this.roomNumber = roomNumber;
        this.layout = layout;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
