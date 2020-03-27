package com.company.dao;

import com.company.entity.Order;
import com.company.information.PriceMenu;
import com.company.reader.InfoReader;
import com.company.users.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrderDaoImpl implements OrderDao {
    static Logger logger = LogManager.getLogger();

    @Override
    public void createOrder(Client client, ArrayList<Order> orders) {
        PriceMenu priceMenu = new PriceMenu();
        priceMenu.showMenu();

        System.out.println("Input new order(dishes must be separated by spaces): ");
        InfoReader reader = new InfoReader();
        String[] dishes = reader.readDish(System.in);
        while(dishes.length == 0) {
            System.out.println("Input correct dishes: ");
            dishes = reader.readDish(System.in);
        }
        ArrayList<String> newDishes = new ArrayList<> (Arrays.asList(dishes));

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

        client.setOrderId(id);
        logger.info("Order is created");
    }

    @Override
    public void showOrdersList(ArrayList<Order> orders) {
       /* Operations op = new Operations();
        op.readOrder(orders, client.getOrderId());*/
        for(Order item : orders) {
            System.out.println(item);
        }
    }

    @Override
    public void deleteOrder(ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
                orders.remove(orders.indexOf(item));
                break;
            }
        }
        logger.info("Order is deleted");
    }

    @Override
    public void updateOrder(Client client, ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
                PriceMenu priceMenu = new PriceMenu();
                priceMenu.showMenu();
                System.out.println("Input dishes to be added to your order(dishes must be separated by spaces): ");
                InfoReader reader = new InfoReader();
                String[] dishes = reader.readDish(System.in);
               /* while(dishes.length == 0) {
                    System.out.println("Input correct dishes: ");
                    dishes = reader.readDish(System.in);
                }*/
                if(dishes.length == 0)
                    break;
                ArrayList<String> currentDishes = item.getDishes();
                for(String str : dishes) {
                    currentDishes.add(str);
                }
                item.setDishes(currentDishes);
                item.setTotal(currentDishes);
                break;
            }
        }
        logger.info("Order is updated");
    }
}
