package org.example.controllers;

import org.example.dao.Medications;
import org.example.service.Service;
import org.example.service.ShowMedications;
import org.example.view.FindMedication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ControllersClass implements Controllers {
    ShowMedications showMedications =new ShowMedications();
    FindMedication findMedication =new FindMedication();
    private Service service;

    public ControllersClass() {
        this.service = new ShowMedications();
    }

    @Override
    public void searchProducts(List<Medications> inventory) {
        Scanner scanner = new Scanner(System.in);
        findMedication.askSearchParameter();
        String parameter = scanner.nextLine().trim().toLowerCase();
        findMedication.askSearchValue();
        String value = scanner.nextLine().trim().toLowerCase();
        List<Medications> results = new ArrayList<>();
        service.searchDrugs(inventory, parameter, value, results);
    }

    @Override
    public void listProducts(List<Medications> inventory) {
        Scanner scanner = new Scanner(System.in);
        findMedication.printView();
        String order = scanner.nextLine().trim().toLowerCase();
        showMedications.listDrug(order, inventory);
    }

    @Override
    public void control() {

        List<Medications> drugs = showMedications.loadInventory();
        ControllersClass controllersClass = new ControllersClass();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (A-C): ");
            String command = scanner.nextLine();
            switch (command) {
                case "A", "a" -> controllersClass.searchProducts(drugs);
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
