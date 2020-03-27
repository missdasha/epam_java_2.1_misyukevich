package com.company.controller;

import com.company.reader.RWClients;
import com.company.users.Administrator;
import com.company.users.Client;
import com.company.users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Authorizer {

    public Client findClientByNameAndPassword(String nickName, String password) {
        RWClients fileReader = new RWClients();
        ArrayList<Client> clients = fileReader.readFromFile();

        for(Client item : clients) {
            if(item.getName().equals(nickName) && item.getPassword().equals(password)){
                System.out.println("Welcome back, " + nickName + "!");
                return item;
            }
        }

        ArrayList<Integer> identifiers = new ArrayList<>();
        for(Client client : clients) {
            identifiers.add(client.getId());
        }
        Collections.sort(identifiers);
        int id;
        if(clients.size() != 0) {
            id = identifiers.get(identifiers.size()-1) + 1;
        }
        else
            id = 1;
        Client newClient = new Client(nickName, password, id);
        clients.add(newClient);

        System.out.println("Welcome to our restaurant, " + nickName + "!");

        RWClients fileWriter = new RWClients();
        fileWriter.writeToFile(clients);
        return newClient;
    }

    public User logIn() {
        String nickName, password;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your nickName:");
        nickName = scanner.nextLine();

        System.out.println("Enter your password:");
        password = scanner.nextLine();

        if(nickName.equals("admin") && password.equals("admin")){
            return new Administrator(nickName, password, 0);
        }
        else{
            return  this.findClientByNameAndPassword(nickName, password);
        }
    }
}
