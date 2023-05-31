package org.example.controllers;

import org.example.dao.Medications;

import java.util.List;
import java.util.Scanner;

import static org.example.service.ShowMedications.listDrug;
import static org.example.view.ShowMedication.printView;

public class Show {

    public static void listProducts(List<Medications> inventory) {
        Scanner scanner = new Scanner(System.in);
        printView();
        String order = scanner.nextLine().trim().toLowerCase();
        listDrug(order, inventory);
    }
}
