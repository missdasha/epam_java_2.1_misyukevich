package com.company.handler;

import com.company.entity.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
        - проверить, есть ли блюда дороже 10
        − Найти блюда с максимальной и минимальной ценой
        − Отфильтровать блюда, с единственным покупателем
        − Отсортировать товары по популярности
*/

public class DishHandler {
    static Logger logger = LogManager.getLogger();
    public boolean hasDishesMoreExpensiveThan(int n, Dish[] dishes){
        Stream<Dish> dishesStream = Arrays.stream(dishes).parallel().filter(dish -> dish.getPrice() > 10);
        Optional<Dish> res = dishesStream.findAny();
        return res.isPresent();
    }

    public Dish findDishesWithMaxPrice(Dish[] dishes){
        Optional<Dish> max = Arrays.stream(dishes).max(Comparator.comparing(Dish::getPrice));
        return max.orElseGet(Dish::new);
    }

    public Dish findDishesWithMinPrice(Dish[] dishes){
        Optional<Dish> min = Arrays.stream(dishes).min(Comparator.comparing(Dish::getPrice));
        return min.orElseThrow(IllegalStateException::new);
    }

    public ArrayList<Dish> filterDishesWithSingleClient(Dish[] dishes){
        long start = System.currentTimeMillis();

        ArrayList<Dish> dishesStream = Arrays.stream(dishes)
                .peek((dish)->System.out.println("Dish name: " + dish.getName()))
                .filter(dish -> dish.getClientList().size() == 1)
                .collect(Collectors.toCollection(ArrayList::new));

        long timeSpent = System.currentTimeMillis() - start;
        logger.info("Time spent: " + timeSpent + " milliseconds");
        return dishesStream;
    }

    public ArrayList<Dish> filterDishesWithSingleClientParallel(Dish[] dishes){
        long start = System.currentTimeMillis();

        ArrayList<Dish> dishesStream = Arrays.stream(dishes).parallel()
                .peek((dish)->System.out.println("Dish name: " + dish.getName()))
                .filter(dish -> dish.getClientList().size() == 1)
                .collect(Collectors.toCollection(ArrayList::new));

        long timeSpent = System.currentTimeMillis() - start;
        logger.info("Time spent with parallel stream: " + timeSpent + " milliseconds");
        return dishesStream;
    }

    public ArrayList<Dish> sortDishesByPopularity(Dish[] dishes){
        return Arrays.stream(dishes)
                .sorted(Comparator.comparingInt(d -> d.getClientList().size()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
