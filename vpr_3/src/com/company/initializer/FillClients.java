package com.company.initializer;

import com.company.entity.Enum;
import com.company.entity.Client;
import com.company.entity.Dish;

import java.util.ArrayList;
import java.util.Arrays;

public class FillClients {
    public Client[] fill() {

        Client[] clientArray = new Client[5];

        clientArray[0] = new Client("Kseniya", Arrays.asList(
                new Dish("Carbonara", 10, new ArrayList<Enum>(Arrays.asList(Enum.PASTA, Enum.HAM, Enum.MUSHROOMS))),
                new Dish("Pizza", 15, new ArrayList<Enum>(Arrays.asList(Enum.CHICKEN, Enum.PINEAPPLE)))
        ),
                "Il Patio");
        clientArray[1] = new Client("Darya", Arrays.asList(
                new Dish("Pizza", 15, new ArrayList<Enum>(Arrays.asList(Enum.CHICKEN, Enum.PINEAPPLE)))
        ),
                "Il Patio");
        clientArray[2] = new Client("Kseniya", Arrays.asList(
                new Dish("Carbonara", 10, new ArrayList<Enum>(Arrays.asList(Enum.PASTA, Enum.HAM, Enum.MUSHROOMS))),
                new Dish("Pizza", 15, new ArrayList<Enum>(Arrays.asList(Enum.CHICKEN, Enum.PINEAPPLE)))
        ),
                "Il Patio");
        clientArray[3] = new Client("Alina", Arrays.asList(
                new Dish("Pancakes", 8, new ArrayList<Enum>(Arrays.asList(Enum.HAM, Enum.MUSHROOMS))),
                new Dish("Salad", 7, new ArrayList<Enum>(Arrays.asList(Enum.CUCUMBERS, Enum.TOMATOES)))
        ),
                "Pizza Tempo");
        clientArray[4] = new Client("Polina", Arrays.asList(
                new Dish("Salad", 7, new ArrayList<Enum>(Arrays.asList(Enum.CUCUMBERS, Enum.TOMATOES))),
                new Dish("Pizza", 15, new ArrayList<Enum>(Arrays.asList(Enum.CHICKEN, Enum.PINEAPPLE)))
        ),
                "Pizza Tempo");
        return clientArray;
    }
}
