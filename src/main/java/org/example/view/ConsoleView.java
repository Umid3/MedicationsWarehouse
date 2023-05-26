package org.example.view;

import static org.example.controller.ConsoleViewController.control;

public class ConsoleView {

    public static void main(String[] args) {
        System.out.println("Inventory Management System v1.0 (Created on April 29, 2023)");
        System.out.println("Developer: John Smith (johnsmith@example.com)");


        // Display the available commands
        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");
        control();
    }
}
