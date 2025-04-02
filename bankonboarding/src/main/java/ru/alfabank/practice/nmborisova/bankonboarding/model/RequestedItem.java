package ru.alfabank.practice.nmborisova.bankonboarding.model;

import ru.alfabank.practice.nmborisova.bankonboarding.util.ProductNotFoundException;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RequestedItem {
    public String id;
    public String name;
    public double price;
    public int amount;
    public double totalPrice;

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

    public void findProduct (Set<Product> productList) throws ProductNotFoundException {
        Optional<Product> optProduct = productList.stream()
                .filter(x -> x.id.equals(this.id))
                .findFirst();
        if (optProduct.isPresent()){
            this.name = optProduct.get().name;
            this.price = optProduct.get().price;
            this.totalPrice = this.price * this.amount;
        }

        else {
            String message = "Product with id " + this.id + " is not in store.";
            throw new ProductNotFoundException(message);
        }
    }
}
