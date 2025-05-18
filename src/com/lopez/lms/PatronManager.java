package com.lopez.lms;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a list of Patron objects and handles operations
 * such as add, remove, display, and file loading.
 */
public class PatronManager {
    private final ArrayList<Patron> patrons = new ArrayList<>();

    /**
     * Adds a new patron to the list.
     */
    public void addPatron(Patron p) {
        patrons.add(p);
    }

    /**
     * Removes a patron from the list by matching ID.
     */
    public void removePatron(String id) {
        patrons.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Displays all patrons currently in the list.
     */
    public void displayAll() {
        for (Patron p : patrons) {
            p.display();
        }
    }

    /**
     * Loads patrons from a text file.
     * Each line must have 4 comma-separated values:
     * ID, Name, Address, Fine
     */
    public void loadFromFile(String filepath) {
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 4) {
                    Patron p = new Patron(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            Double.parseDouble(data[3].trim())
                    );
                    addPatron(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    /**
     * Retrieves a patron by ID.
     * Returns null if not found.
     */
    public Patron getPatronById(String id) {
        for (Patron p : patrons) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
}
