package ru.alfabank.practice.nmborisova.bankonboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alfabank.practice.nmborisova.bankonboarding.model.GreetingForm;
import ru.alfabank.practice.nmborisova.bankonboarding.model.Product;
import ru.alfabank.practice.nmborisova.bankonboarding.model.Request;
import ru.alfabank.practice.nmborisova.bankonboarding.model.RequestedItem;
import ru.alfabank.practice.nmborisova.bankonboarding.service.ShopService;
import ru.alfabank.practice.nmborisova.bankonboarding.util.ProductNotFoundException;

import java.util.Set;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/welcome")
    public GreetingForm greet() {
       return shopService.greet();
    }

    @GetMapping("/product")
    public Set<Product> getProductList () {
        return shopService.getProductList();
    }

    @PostMapping("/calc")
    public Request calculateTotal(@RequestBody Set<RequestedItem> request) throws ProductNotFoundException {
        return shopService.calculateTotalPrice(request);
    }
}
