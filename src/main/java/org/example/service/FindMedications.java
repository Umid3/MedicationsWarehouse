package org.example.service;

import org.example.dao.Medications;

import java.util.List;

public class FindMedications {

    public static void searchDrugs(List<Medications> inventory, String parameter, String value, List<Medications> results) {
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
}
