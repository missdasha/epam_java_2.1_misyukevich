package com.company.operations;

import com.company.entity.Order;
import com.company.information.Menu;
import com.company.reader.InfoReader;
import com.company.reader.RWFiles;
import com.sun.deploy.security.SelectableSecurityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Operations {
    static Logger logger = LogManager.getLogger();
    public void makeOperations(ArrayList<Order> orders, int n) {
        int id;
        switch (n) {
            case 1:
                createOrder(orders);
                break;
            case 2:
                showOrdersList(orders);
                break;
            case 3:
                showOrdersList(orders);
                id = chooseIdentifier(orders);
                System.out.println(id);
                updateOrder(orders, id);
                break;
            case 4:
                showOrdersList(orders);
                id = chooseIdentifier(orders);
                deleteOrder(orders, id);
                break;
            case 0:
                RWFiles fileWriter = new RWFiles();
                fileWriter.writeToFile(orders);
                logger.info("Changes saved");
                break;
        }
    }

    public void createOrder(ArrayList<Order> orders) {
        Menu menu = new Menu();
        menu.showMenu();

        System.out.println("Input new order(dishes must be separated by spaces): ");
        InfoReader reader = new InfoReader();
        ArrayList<String> newDishes = new ArrayList<> (Arrays.asList(reader.readDish(System.in)));

        ArrayList<Integer> identifiers = new ArrayList<>();
        for(Order ord : orders) {
            identifiers.add(ord.getId());
        }
        Collections.sort(identifiers);
        int id;
        if(orders.size() != 0)
            id = identifiers.get(identifiers.size()-1) + 1;
        else
            id = 1;
        Order newOrder = new Order(id, newDishes);
        orders.add(newOrder);
    }

    public void showOrdersList(ArrayList<Order> orders) {
        for(Order item : orders) {
            System.out.println(item);
        }
    }

    public int chooseIdentifier(ArrayList<Order> orders) {
        InfoReader reader = new InfoReader();
        ArrayList<Integer> identifiers = new ArrayList<>();
        for(Order ord : orders) {
            identifiers.add(ord.getId());
        }
        System.out.println("Input an id: ");
        int id = reader.readId(System.in);
        while(!identifiers.contains(id)) {
            System.out.println("Input correct id: ");
            id = reader.readId(System.in);
        }
        return id;
    }

    public void readOrder(ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
                System.out.println(item.toString());
                break;
            }
        }
    }

    public void deleteOrder(ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
                orders.remove(orders.indexOf(item));
                break;
            }
        }
    }

    public void updateOrder(ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
                Menu menu = new Menu();
                menu.showMenu();
                System.out.println("Input updated order(dishes must be separated by spaces): ");
                InfoReader reader = new InfoReader();
                ArrayList<String> newDishes = new ArrayList<> (Arrays.asList(reader.readDish(System.in)));
                item.setDishes(newDishes);
                item.setTotal(newDishes);
                break;
            }
        }
    }

}
