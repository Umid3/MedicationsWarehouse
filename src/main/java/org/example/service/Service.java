package org.example.service;

import org.example.dao.Medications;

import java.util.List;

public interface Service {
     public void searchDrugs(List<Medications> inventory, String parameter, String value, List<Medications> results);
     public List<Medications> loadInventory();
     public void listDrug(String order, List<Medications> drugs);

}
