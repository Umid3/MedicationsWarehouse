package org.example.view;

public class ShowMedication implements View{

    @Override
    public void askSearchParameter() {

    }

    @Override
    public void askSearchValue() {

    }
    @Override
    public void printView(){
        System.out.print("Enter sort order (ID, name, type, price, amount): ");
    }
}
