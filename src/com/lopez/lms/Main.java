package com.lopez.lms;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatronManager manager = new PatronManager();

    public static void main(String[] args) {
        System.out.print("Enter file path to load patrons: ");
        String path = scanner.nextLine();
        manager.loadFromFile(path);
        manager.displayAll();

        boolean running = true;
        while (running) {
            printMenu();
            switch (scanner.nextLine()) {
                case "1" -> addPatronFlow();
                case "2" -> removePatronFlow();
                case "3" -> manager.displayAll();
                case "4" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n1. Add Patron");
        System.out.println("2. Remove Patron");
        System.out.println("3. Display All Patrons");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void addPatronFlow() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Fine (0-250): ");
        double fine = Double.parseDouble(scanner.nextLine());
        manager.addPatron(new Patron(id, name, address, fine));
    }

    public static void removePatronFlow() {
        System.out.print("Enter ID of patron to remove: ");
        String id = scanner.nextLine();
        manager.removePatron(id);
    }
}
