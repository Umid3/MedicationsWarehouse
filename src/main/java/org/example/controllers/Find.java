package org.example.controllers;

import org.example.dao.Medications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.FindMedications.searchDrugs;
import static org.example.view.FindMedication.askSearchParameter;
import static org.example.view.FindMedication.askSearchValue;

public class Find {
    public static void searchProducts(List<Medications> inventory) {
        Scanner scanner = new Scanner(System.in);
        askSearchParameter();
        String parameter = scanner.nextLine().trim().toLowerCase();
        askSearchValue();
        String value = scanner.nextLine().trim().toLowerCase();
        List<Medications> results = new ArrayList<>();
        searchDrugs(inventory, parameter, value, results);
    }

}
