package org.example.dao;

public class Medications {
    private int id;
    private String Name;
    private String Type;
    private double Price;
    private int Amount;

    public Medications(int id, String Name, String Type, double Price, int Amount) {
        this.id = id;
        this.Name = Name;
        this.Type = Type;
        this.Price = Price;
        this.Amount = Amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public double getPrice() {
        return Price;
    }

    public int getAmount() {
        return Amount;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%8.2f%5d", id, Name, Type, Price, Amount);
    }
}
