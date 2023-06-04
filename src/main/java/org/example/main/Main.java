package org.example.main;

import org.example.controllers.ControllersClass;

public class Main {
    static ControllersClass controllersClass =new ControllersClass();

    public static void main(String[] args) {
        System.out.println("Store application (Created on April 29, 2023)");
        System.out.println("Developer: Umid Ortikov (umid_ortikov@student.itpu.uz)");
        System.out.println("\n______________________________________________");
        System.out.println(" \t \t \t Medications Warehouse");
        System.out.println("______________________________________________");


        System.out.println("\nAvailable commands:");
        System.out.println("A. Search products");
        System.out.println("B. Show all products");
        System.out.println("C. Exit");
        controllersClass.control();
    }
}
