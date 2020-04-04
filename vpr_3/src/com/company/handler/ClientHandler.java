package com.company.handler;

import com.company.entity.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
/*
        − Получить список клиентов
        − Напечатать информацию о клиентах, используя foreach
        − Получить список клиентов без дубликатов
*/

public class ClientHandler {
    public ArrayList<String> getClientsList(Client[] clients) {
        return Arrays.stream(clients).map((s) -> s.getName()).collect(Collectors.toCollection(ArrayList::new));
    }

    public void printInformationAboutClients(Client[] clients) {
        Arrays.stream(clients).forEach(client -> System.out.print(client.toString(true)));
    }

    public ArrayList<Client> getClientsListWithoutDuplicates(Client[] clients) {
        return Arrays.stream(clients).distinct().collect(Collectors.toCollection(ArrayList::new));
    }
}
