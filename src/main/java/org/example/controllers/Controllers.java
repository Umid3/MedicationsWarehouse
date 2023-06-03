package org.example.controllers;

import org.example.dao.Medications;

import java.util.List;

public interface Controllers {
    public void searchProducts(List<Medications> inventory);
    public void listProducts(List<Medications> inventory);
    public void control();
}
