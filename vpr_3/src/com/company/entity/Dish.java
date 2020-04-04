package com.company.entity;

import java.util.List;

public class Dish {
    private String name;
    private int price;
    private List<Enum> componentList;
    private List<Client> clientList;

    public Dish() {
        this.name = null;
        this.price = 0;
        this.componentList = null;
        this.clientList = null;
    }

    public Dish(String name, int price, List<Enum> componentList, List<Client> clientList) {
        this.name = name;
        this.price = price;
        this.componentList = componentList;
        this.clientList = clientList;
    }

    public Dish(String name, int price, List<Enum> componentList) {
        this.name = name;
        this.price = price;
        this.componentList = componentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Enum> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Enum> componentList) {
        this.componentList = componentList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", componentList=" + componentList +
                '}';
    }

    public String toString(boolean b){
        StringBuilder s = new StringBuilder();
        s.append("Dish{ name= " + name + ", price=" + price + ", componentList=" + componentList + ", clientList=[ " );
        clientList.forEach(client -> s.append(client.toString() + " "));
        s.append("]\n");
        return s.toString();
    }
}
