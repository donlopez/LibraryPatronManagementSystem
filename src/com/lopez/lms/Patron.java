package com.lopez.lms;

/**
 * Represents a single library patron with ID, name, address, and fine balance.
 * This class serves as the data model for each individual patron.
 */
public class Patron {
    private String id;
    private String name;
    private String address;
    private double fine;

    // Constructor to initialize a new Patron
    public Patron(String id, String name, String address, double fine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fine = fine;
    }

    // Getters and setters for Patron fields
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getFine() { return fine; }
    public void setFine(double fine) { this.fine = fine; }

    /**
     * Prints patron information in a readable format.
     */
    public void display() {
        System.out.printf("ID: %s | Name: %s | Address: %s | Fine: %.2f%n", id, name, address, fine);
    }
}
