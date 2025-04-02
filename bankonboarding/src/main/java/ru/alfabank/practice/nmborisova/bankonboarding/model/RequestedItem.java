package ru.alfabank.practice.nmborisova.bankonboarding.model;

import ru.alfabank.practice.nmborisova.bankonboarding.util.ProductNotFoundException;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RequestedItem {
    private String id;
    private String name;
    private double price;
    private int amount;
    private double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestedItem requestedItem = (RequestedItem) o;
        return Objects.equals(id, requestedItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void findProduct (Set<Product> productList) throws ProductNotFoundException {
        Optional<Product> optProduct = productList.stream()
                .filter(x -> x.getId().equals(this.id))
                .findFirst();
        if (optProduct.isPresent()){
            this.name = optProduct.get().getName();
            this.price = optProduct.get().getPrice();
            this.totalPrice = this.price * this.amount;
        }

        else {
            String message = "Product with id " + this.id + " is not in store.";
            throw new ProductNotFoundException(message);
        }
    }
}
