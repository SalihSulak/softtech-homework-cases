package com.salihsulak.model;

public abstract class Residence {
    private final int id;
    private int price;
    private final int squareMeters;
    private final int numberOfRooms;
    private final int numberOfLivingRooms;

    public Residence(int id, int price, int squareMeters, int numberOfRooms, int numberOfLivingRooms) {
        this.id = id;
        this.price = price;
        this.squareMeters = squareMeters;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLivingRooms = numberOfLivingRooms;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfLivingRooms() {
        return numberOfLivingRooms;
    }

}
