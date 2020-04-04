package com.company;

import com.company.entity.Client;
import com.company.entity.Dish;
import com.company.initializer.FillClients;
import com.company.initializer.FillDishes;
import com.company.handler.ClientHandler;
import com.company.handler.DishHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Array of dishes: ");
        FillDishes initDishes = new FillDishes();
        Dish [] dishes = initDishes.fill();
        for(Dish dish : dishes) {
            System.out.print(dish.toString(true));
        }
        System.out.println();

        logger.info("Array of clients: ");
        FillClients initClients = new FillClients();
        Client [] clients = initClients.fill();
        for(Client client : clients) {
            System.out.print(client.toString(true));
        }
        System.out.println();

        DishHandler dishHandler = new DishHandler();

        int n = 10;
        if (dishHandler.hasDishesMoreExpensiveThan(10, dishes)) {
            System.out.println("There are dishes with price > " + n);
        } else {
            System.out.println("There are not dishes with price > " + n);
        }
        System.out.println();

        Dish max = dishHandler.findDishesWithMaxPrice(dishes);
        System.out.println("Dish with max price:\n" + max.toString(true));

        Dish min = dishHandler.findDishesWithMinPrice(dishes);
        System.out.println("Dish with min price:\n" + min.toString(true));

        ArrayList<Dish> sortedDishesWithSingleClient = dishHandler.filterDishesWithSingleClient(dishes);
        System.out.println("Dishes with single client: ");
        sortedDishesWithSingleClient.forEach(dish -> System.out.print(dish.toString(true)));
        System.out.println();

        ArrayList<Dish> sortedDishesWithSingleClientPar = dishHandler.filterDishesWithSingleClientParallel(dishes);
        System.out.println("Dishes with single client: ");
        sortedDishesWithSingleClientPar.forEach(dish -> System.out.print(dish.toString(true)));
        System.out.println();

        ArrayList<Dish> sortedByPopularity = dishHandler.sortDishesByPopularity(dishes);
        System.out.println("Sorted By Popularity: ");
        sortedByPopularity.forEach(dish -> System.out.print(dish.toString(true)));
        System.out.println();

        ClientHandler clientHandler = new ClientHandler();

        System.out.println("Information About Clients: ");
        clientHandler.printInformationAboutClients(clients);
        System.out.println();

        ArrayList<Client> clientsListWithoutDuplicates = clientHandler.getClientsListWithoutDuplicates(clients);
        System.out.println("Clients List Without Duplicates: ");
        clientsListWithoutDuplicates.forEach(cl -> System.out.print(cl.toString(true)));
        System.out.println();

        ArrayList<String> clientsList = clientHandler.getClientsList(clients);
        System.out.println("Clients List: ");
        clientsList.forEach(System.out::println);
        System.out.println();
    }
}
