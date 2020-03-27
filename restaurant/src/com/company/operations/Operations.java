package com.company.operations;

import com.company.entity.Order;
import com.company.reader.InfoReader;
import com.company.users.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    static Logger logger = LogManager.getLogger();

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
        if(id == 0)
            System.out.println("You have no orders yet");
    }

    public Order getOrderById(ArrayList<Order> orders, int id) {
        for(Order item : orders) {
            if(item.getId() == id) {
              return item;
            }
        }
        return null;
    }

   public void payForOrder(Client client, Order order) {
       Scanner scanner = new Scanner(System.in);
       System.out.println(order.toString());
       System.out.println("Total: " + order.getTotal());
       System.out.print("Input 'pay' to pay: ");
       String key = scanner.nextLine();
       while(!key.equals("pay")) {
           System.out.print("Input 'pay' to pay: ");
           key = scanner.nextLine();
       }
       client.setOrderId(0);
       client.setPaid(true);
       logger.info("Payment succeed");
    }

    public void showClients(ArrayList<Client> clients) {
        for(Client client : clients) {
            System.out.println(client);
        }
    }

    public void deleteClient(ArrayList<Client> clients, int id) {
        for(Client client : clients) {
            if(client.getId() == id) {
                clients.remove(clients.indexOf(client));
                break;
            }
        }
        logger.info("Client is deleted");
    }

    public int chooseClientIdentifier(ArrayList<Client> clients) {
        InfoReader reader = new InfoReader();
        ArrayList<Integer> identifiers = new ArrayList<>();
        for(Client client : clients) {
            identifiers.add(client.getId());
        }
        System.out.println("Input an id: ");
        int id = reader.readId(System.in);
        while(!identifiers.contains(id)) {
            System.out.println("Input correct id: ");
            id = reader.readId(System.in);
        }
        return id;
    }
}
