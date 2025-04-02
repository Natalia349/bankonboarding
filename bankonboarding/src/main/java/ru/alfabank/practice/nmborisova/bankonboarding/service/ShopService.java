package ru.alfabank.practice.nmborisova.bankonboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alfabank.practice.nmborisova.bankonboarding.model.GreetingForm;
import ru.alfabank.practice.nmborisova.bankonboarding.model.Product;
import ru.alfabank.practice.nmborisova.bankonboarding.model.Request;
import ru.alfabank.practice.nmborisova.bankonboarding.model.RequestedItem;
import ru.alfabank.practice.nmborisova.bankonboarding.util.ProductNotFoundException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class ShopService {
    @Autowired
    private GreetingForm greetingForm;

    private final Set<Product> productList = new HashSet<>();

    {
        productList.add(new Product("Milk", 2.4));
        productList.add(new Product("Bread", 1.0));
        productList.add(new Product("Eggs, 10", 3.5));
        productList.add(new Product("Potatoes, 1kg", 1.6));
    }

    public GreetingForm greet() {
        return greetingForm;
    }

    public Set<Product> getProductList() {

        return productList;
    }

    public Request calculateTotalPrice(Set<RequestedItem> request) throws ProductNotFoundException {
        double total=0;
        for (RequestedItem item : request) {
            item.findProduct(productList);
            total += item.getTotalPrice();
        }
        return new Request(total, request);
    }
}
