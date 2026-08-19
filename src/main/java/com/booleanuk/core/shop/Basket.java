package com.booleanuk.core.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    // private List<Item> items;
    private Map<Item, Integer> items;

    public Basket() {

        // items = new ArrayList<>();
        items = new HashMap<>();
    }

    public void add(Item it, int quantity) {

        // items.add(it);
        items.put(it, quantity);
    }
    public void add(Item item) {

        add(item, 1);
    }

    public float getPriceTot() {

        float sum = 0;
        for (Item it : items.keySet()) {

            final float price = it.getPrice();

            if (price <= 0)
                throw new IllegalArgumentException();

            sum += price;
        }

        return sum;
    }

    public String getReceipt() {
     
        String res = "";

        for (Item it : items.keySet()) {

            int quantity = items.get(it);

            res += it.getName() + " " + quantity + "x " 
                + String.format("%.2f", it.getPrice()) 
                + "$\n";
        }

        res += "---\n" 
            + String.format("%.2f", getPriceTot()) 
            + "$";

        return res;
    }
}
