package com.culture.API.Models.Request;

public class Location {
    private int id;
    private Position position;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Location(int id, Position position) {
        this.id = id;
        this.position = position;
    }
    public Location() {
    }

    
}
