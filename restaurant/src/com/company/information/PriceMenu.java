package com.company.information;

import java.util.HashMap;
import java.util.Map;

public class PriceMenu {
    public Map<String, Double> menu;

    public PriceMenu() {
        this.menu = new HashMap<>();

        this.menu.put("Croissant", 2.5);
        this.menu.put("Baguette", 2.0);
        this.menu.put("Ratatouille", 6.0);
        this.menu.put("Macarons", 4.0);
    }

    public void showMenu() {
        for(Map.Entry<String, Double> item : menu.entrySet()){
            System.out.printf("Dish: %s  Price: %4.2f \n", item.getKey(), item.getValue());
        }
    }
}
