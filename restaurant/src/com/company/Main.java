package com.company;

import com.company.entity.Order;
import com.company.information.Menu;
import com.company.operations.Operations;
import com.company.reader.InfoReader;
import com.company.reader.RWFiles;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws IOException {
        logger.info("Start");

        RWFiles fileReader = new RWFiles();
        Operations operation = new Operations();
        ArrayList<Order> orders = fileReader.readFromFile();

        InfoReader reader = new InfoReader();
        int n = 1;
        while (n != 0) {
            System.out.println("Choose an option:");
            System.out.println("1. Create an order");
            System.out.println("2. Show orders");
            System.out.println("3. Update an order");
            System.out.println("4. Delete an order");
            System.out.println("0. Exit and save changes");

            n = reader.readInt(System.in);
            operation.makeOperations(orders, n);
        }

    }

}
