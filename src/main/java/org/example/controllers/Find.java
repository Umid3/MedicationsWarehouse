package org.example.controllers;

import org.example.dao.Medications;
import org.example.service.FindMedications;
import org.example.service.Service;
import org.example.view.FindMedication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Find implements Controllers {
    FindMedication findMedication =new FindMedication();
    private Service service;

    public Find() {
        this.service = new FindMedications();
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
        // implementation goes here
    }

    @Override
    public void control() {
        // implementation goes here
    }
}
