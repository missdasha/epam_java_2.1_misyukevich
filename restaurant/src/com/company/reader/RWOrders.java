package com.company.reader;

import com.company.entity.Order;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RWOrders {
    static Logger logger = LogManager.getLogger();
    public void writeToFile(ArrayList<Order> orders) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resources/orders.txt")))
        {
            oos.writeObject(orders);
            oos.flush();
            oos.close();
        }
        catch(Exception ex){
            logger.log(Level.ERROR, "File writing error", ex);
        }
    }

    public ArrayList<Order> readFromFile() {
        ArrayList<Order> orders = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/orders.txt")))
        {
            orders = ((ArrayList<Order>)ois.readObject());
            ois.close();
        }
        catch(Exception ex){
            logger.log(Level.ERROR, "File reading error", ex);
        }
        return orders;
    }
}
