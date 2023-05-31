package org.example.service;

import org.example.dao.Medications;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadMedications {

    public static List<Medications> loadInventory() {
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

}
