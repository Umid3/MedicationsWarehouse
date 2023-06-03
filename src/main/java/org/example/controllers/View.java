package org.example.controllers;

import org.example.dao.Medications;
import org.example.service.LoadMedications;

import java.util.List;
import java.util.Scanner;

public class View {
    LoadMedications loader = new LoadMedications();

    public void control() {
        List<Medications> drugs = loader.loadInventory();
        Find find = new Find();
        Show show = new Show();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (A-C): ");
            String command = scanner.nextLine();
            switch (command) {
                case "A", "a" -> find.searchProducts(drugs);
                case "B", "b" -> show.listProducts(drugs);
                case "C", "c" -> {
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                }
                default -> System.out.println("Invalid command. Please enter a valid command (A-C).");
            }
        }
    }
}
