package com.company.initializer;

import com.company.entity.Client;
import com.company.entity.Dish;
import com.company.entity.Enum;
import java.util.ArrayList;
import java.util.Arrays;

public class FillDishes {

    public Dish[] fill() {

        Dish[] dishArray = new Dish[4];

        dishArray[0] = new Dish("Carbonara", 10, new ArrayList<Enum>(Arrays.asList(Enum.PASTA, Enum.HAM, Enum.MUSHROOMS)), Arrays.asList(
            new Client("Kseniya", "Il Patio")
        ));

        dishArray[1] = new Dish("Pizza", 15, new ArrayList<Enum>(Arrays.asList(Enum.PASTA, Enum.HAM, Enum.MUSHROOMS)), Arrays.asList(
                new Client("Darya", "Il Patio"),
                new Client("Kseniya", "Il Patio"),
                new Client("Polina", "Pizza Tempo")
        ));

        dishArray[2] = new Dish("Pancakes", 8, new ArrayList<Enum>(Arrays.asList(Enum.HAM, Enum.MUSHROOMS)),
                Arrays.asList( new Client("Alina", "Pizza Tempo")));

        dishArray[3] = new Dish("Salad", 7, new ArrayList<Enum>(Arrays.asList(Enum.CUCUMBERS, Enum.TOMATOES)),
                Arrays.asList(
                        new Client("Polina", "Pizza Tempo"),
                        new Client("Alina", "Pizza Tempo")
                ));

        return dishArray;
    }
}
