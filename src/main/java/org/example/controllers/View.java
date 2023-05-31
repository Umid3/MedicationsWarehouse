package org.example.controllers;

import org.example.dao.Medications;

import java.util.List;
import java.util.Scanner;

import static org.example.controllers.Show.listProducts;
import static org.example.service.LoadMedications.loadInventory;
import static org.example.controllers.Find.searchProducts;

public class View {

    public static void control() {
        List<Medications> drugs = loadInventory();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (A-C): ");
            String command = scanner.nextLine();
            switch (command) {
                case "A", "a" -> searchProducts(drugs);
                case "B", "b" -> listProducts(drugs);
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
