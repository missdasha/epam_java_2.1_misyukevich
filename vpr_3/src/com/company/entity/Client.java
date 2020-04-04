package com.company.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Client implements Comparable, Serializable {
    private String name;
    private List<Dish> lunch;
    private String location;

    public Client(String name, List<Dish> lunch, String location) {
        this.name = name;
        this.lunch = lunch;
        this.location = location;
    }
    public Client(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getLunch() {
        return lunch;
    }

    public void setLunch(List<Dish> lunch) {
        this.lunch = lunch;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String toString(boolean b) {
        StringBuilder s = new StringBuilder();
        s.append("Dish{ name= " + name + ", location=" + location + ", lunch=[ " );
        lunch.forEach(dish -> s.append(dish.toString() + " "));
        s.append("]\n");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(location, client.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
