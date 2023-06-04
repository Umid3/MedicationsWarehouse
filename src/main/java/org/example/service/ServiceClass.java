package org.example.service;

import org.example.dao.Medications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceClass implements Service{


    @Override
    public void searchDrugs(List<Medications> inventory, String parameter, String value, List<Medications> results) {

        for (Medications medications : inventory) {
            switch (parameter) {
                case "id":
                    if (medications.getId() == Integer.parseInt(value)) {
                        results.add(medications);
                    }
                    break;
                case "name":
                    if (medications.getName().toLowerCase().contains(value)) {
                        results.add(medications);
                    }
                    break;
                case "type":
                    if (medications.getType().toLowerCase().contains(value)) {
                        results.add(medications);
                    }
                    break;
                case "price":
                    if (medications.getPrice() == Double.parseDouble(value)) {
                        results.add(medications);
                    }
                    break;
                case "amount":
                    if (medications.getAmount() == Integer.parseInt(value)) {
                        results.add(medications);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
                    return;
            }
        }
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (Medications medications : results) {
            System.out.println(medications);
        }
    }

    @Override
    public  List<Medications> loadInventory() {
        List<Medications> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/dao/Medications.csv"))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                Medications medications = new Medications(id, name, category, price, quantity);
                inventory.add(medications);
            }
        } catch (IOException e) {
            System.err.println("Error reading Medications.csv file: " + e.getMessage());
        }

        return inventory;
    }

    @Override
    public void listDrug(String order, List<Medications> drugs) {
        List<Medications> sorted = new ArrayList<>(drugs);
        switch (order) {
            case "id":
                Collections.sort(sorted, Comparator.comparingInt(Medications::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(Medications::getName));
                break;
            case "type":
                Collections.sort(sorted, Comparator.comparing(Medications::getType));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(Medications::getPrice));
                break;
            case "amount":
                Collections.sort(sorted, Comparator.comparingInt(Medications::getAmount));
                break;
            default:
                System.out.println("Invalid sort order.");
                return;
        }
        System.out.println("Product list:");
        System.out.println("________________________________________________________________");
        System.out.println("ID \t Name \t\t\t\t Type\t\t\t\t\tPrice \t Amount");
        System.out.println("________________________________________________________________");
        for (Medications drug : sorted) {
            System.out.println(drug);
        }
    }
}
