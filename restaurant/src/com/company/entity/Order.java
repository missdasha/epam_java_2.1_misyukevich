package com.company.entity;

import com.company.information.PriceMenu;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable{
    private int id;
    private ArrayList<String> dishes;
    private double total;
    public Order() {
        this.id = 0;
        this.dishes = null;
        this.total = 0;
    }

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
        PriceMenu priceMenu = new PriceMenu();
        double total = 0;
        for(String str : dishes) {
            total += priceMenu.menu.get(str);
        }
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof Order)) {
            return false;
        }

        Order order = (Order) o;
        return (this.total == order.total &&
                this.id == order.id &&
                this.dishes.equals(order.dishes));
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
