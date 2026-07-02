package com.mranand4.lld.model.cinema;

import java.util.List;
import java.util.UUID;

public class Cinema {

    private String id;
    private String name;
    private String address;
    private List<Room> rooms;

    public Cinema(String name, String address, List<Room> rooms) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
