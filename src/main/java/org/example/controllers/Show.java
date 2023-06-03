package org.example.controllers;

import org.example.dao.Medications;
import org.example.service.ShowMedications;
import org.example.view.ShowMedication;

import java.util.List;
import java.util.Scanner;


public class Show implements Controllers{


    ShowMedications showMedications =new ShowMedications();
    ShowMedication  showMedication =new ShowMedication();

    @Override
    public void searchProducts(List<Medications> inventory) {

    }

    @Override
    public void listProducts(List<Medications> inventory) {
        Scanner scanner = new Scanner(System.in);
        showMedication.printView();
        String order = scanner.nextLine().trim().toLowerCase();
        showMedications.listDrug(order, inventory);
    }

    @Override
    public void control() {

    }
}
