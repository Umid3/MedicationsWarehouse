package org.example.view;

public class FindMedication implements View{
    
    @Override
    public void askSearchParameter() {
        System.out.print("Enter search parameter (ID, name, type, price, amount): ");
    }

    @Override
    public void askSearchValue() {
        System.out.print("Enter search value: ");
    }

    @Override
    public void printView(){
        System.out.print("Enter sort order (ID, name, type, price, amount): ");
    }
}

