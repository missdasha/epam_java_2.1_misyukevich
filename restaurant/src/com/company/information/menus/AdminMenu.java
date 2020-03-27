package com.company.information.menus;

import com.company.dao.OrderDao;
import com.company.dao.OrderDaoImpl;
import com.company.entity.Order;
import com.company.operations.Operations;
import com.company.reader.RWClients;
import com.company.reader.RWOrders;
import com.company.users.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class AdminMenu {
    ArrayList<Client> clients;
    ArrayList<Order> orders;

    private static OrderDao orderDao;
    static Logger logger = LogManager.getLogger();

    public AdminMenu() {
        RWOrders ordersReader = new RWOrders();
        RWClients clientsReader = new RWClients();
        this.orders = ordersReader.readFromFile();
        this.clients = clientsReader.readFromFile();
    }

    public void showAdminMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Show clients");
        System.out.println("2. Show previous orders");
        System.out.println("3. Delete client");
        System.out.println("4. Delete order");
        System.out.println("0. Exit");
        System.out.print(">> ");
    }

    public void makeOperations(int n) {
        orderDao = new OrderDaoImpl();
        Operations operation = new Operations();
        int id;
        switch (n) {
            case 1:
                operation.showClients(clients);
                break;
            case 2:
                orderDao.showOrdersList(orders);
                break;
            case 3:
                operation.showClients(clients);
                id = operation.chooseClientIdentifier(clients);
                operation.deleteClient(clients, id);
                break;
            case 4:
                orderDao.showOrdersList(orders);
                id = operation.chooseIdentifier(orders);
                orderDao.deleteOrder(orders, id);
                break;
            case 0:
                RWOrders ordersWriter = new RWOrders();
                RWClients clientsWriter = new RWClients();
                ordersWriter.writeToFile(orders);
                clientsWriter.writeToFile(clients);
                logger.info("Changes saved");
                break;
        }
    }
}
