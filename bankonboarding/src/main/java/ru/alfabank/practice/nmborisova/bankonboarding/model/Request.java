package ru.alfabank.practice.nmborisova.bankonboarding.model;

import java.util.Set;

public class Request {
    private double totalPrice;
    private Set<RequestedItem> itemsList;

    public Request(double totalPrice, Set<RequestedItem> itemsList) {
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<RequestedItem> getItemsList() {
        return itemsList;
    }
}
