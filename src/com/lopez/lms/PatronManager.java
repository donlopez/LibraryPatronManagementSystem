package com.lopez.lms;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PatronManager {
    private final ArrayList<Patron> patrons = new ArrayList<>();

    public void addPatron(Patron p) {
        patrons.add(p);
    }

    public void removePatron(String id) {
        patrons.removeIf(p -> p.getId().equals(id));
    }

    public void displayAll() {
        for (Patron p : patrons) {
            p.display();
        }
    }

    public void loadFromFile(String filepath) {
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 4) {
                    Patron p = new Patron(data[0].trim(), data[1].trim(), data[2].trim(), Double.parseDouble(data[3].trim()));
                    addPatron(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public Patron getPatronById(String id) {
        for (Patron p : patrons) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
}
