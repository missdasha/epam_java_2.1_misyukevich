package com.company.dao;

import com.company.entity.Order;
import com.company.users.Client;

import java.util.ArrayList;

public interface OrderDao {
    public void createOrder(Client client, ArrayList<Order> orders);
    public void showOrdersList(ArrayList<Order> orders);
    public void deleteOrder(ArrayList<Order> orders, int id);
    public void updateOrder(Client client, ArrayList<Order> orders, int id);
}
