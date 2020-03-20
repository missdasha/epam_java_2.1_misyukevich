package com.company.entity;

import com.company.information.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Order implements Serializable{
    private int id;
    private ArrayList<String> dishes;
    private double total;

    public Order(int id, ArrayList<String> dishes, double total) {
        this.id = id;
        this.dishes = dishes;
        this.total = total;
    }

    public Order(int id, ArrayList<String> dishes) {
        this.id = id;
        this.dishes = dishes;
        setTotal(dishes);
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getDishes() {
        return dishes;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDishes(ArrayList<String> dishes) {
        this.dishes = dishes;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotal(ArrayList<String> dishes) {
        Menu menu = new Menu();
        double total = 0;
        for(String str : dishes) {
            total += menu.menu.get(str);
        }
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", total=" + total +
                '}';
    }
}
