package org.example.service;

import org.example.dao.Medications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowMedications implements Service{


    @Override
    public void searchDrugs(List<Medications> inventory, String parameter, String value, List<Medications> results) {

    }

    @Override
    public List<Medications> loadInventory() {
        return null;
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
