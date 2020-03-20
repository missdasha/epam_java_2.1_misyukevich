package com.company.reader;

import com.company.entity.Order;
import com.company.operations.Operations;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RWFiles {
    static Logger logger = LogManager.getLogger();
    public void writeToFile(ArrayList<Order> orders) {
        // "resources/ord.txt" ???
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Пользователь\\IdeaProjects\\restaurant\\src\\orders.txt")))
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
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Пользователь\\IdeaProjects\\restaurant\\src\\orders.txt")))
        {
            orders=((ArrayList<Order>)ois.readObject());
            ois.close();
        }
        catch(Exception ex){
            logger.log(Level.ERROR, "File reading error", ex);
        }
        return orders;
    }
}
