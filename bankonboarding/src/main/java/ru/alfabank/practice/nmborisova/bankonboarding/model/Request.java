package ru.alfabank.practice.nmborisova.bankonboarding.model;

import java.util.Set;

public class Request {
    public double totalPrice;
    public Set<RequestedItem> itemsList;

    public Request(double totalPrice, Set<RequestedItem> itemsList) {
        this.totalPrice = totalPrice;
        this.itemsList = itemsList;
    }
}
