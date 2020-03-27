package com.company.information.menus;

import com.company.entity.Order;
import com.company.dao.OrderDao;
import com.company.dao.OrderDaoImpl;
import com.company.operations.Operations;
import com.company.reader.RWOrders;
import com.company.users.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ClientMenu {
    Client client;
    ArrayList<Order> orders;

    private static OrderDao orderDao;
    static Logger logger = LogManager.getLogger();

    public ClientMenu(Client client) {
        this.client = client;

        RWOrders fileReader = new RWOrders();
        this.orders = fileReader.readFromFile();
    }

    public void showClientMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Create an order");
        System.out.println("2. Show order");
        System.out.println("3. Add dishes to order");
        System.out.println("4. Pay for order");
        System.out.println("0. Exit and save changes");
        System.out.print(">> ");
    }

    public void makeOperations(int n) {
        orderDao = new OrderDaoImpl();
        Operations operation = new Operations();

        switch (n) {
            case 1:
                orderDao.createOrder(client, orders);
                break;
            case 2:
                operation.readOrder(orders, client.getOrderId());
                break;
            case 3:
                operation.readOrder(orders, client.getOrderId());
                orderDao.updateOrder(client, orders, client.getOrderId());
                break;
            case 4:
                Order order = operation.getOrderById(orders, client.getOrderId());
                operation.payForOrder(client, order);
                break;
            case 0:
                while(client.isPaid() == false) {
                    order = operation.getOrderById(orders, client.getOrderId());
                    operation.payForOrder(client, order);
                }
                RWOrders fileWriter = new RWOrders();
                fileWriter.writeToFile(orders);
                logger.info("Changes saved");
                break;
        }
    }
}
