package com.company.reader;

import com.company.users.Client;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RWClients {
    static Logger logger = LogManager.getLogger();
    public void writeToFile(ArrayList<Client> clients) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resources/clients.txt")))
        {
            oos.writeObject(clients);
            oos.flush();
            oos.close();
        }
        catch(Exception ex){
            logger.log(Level.ERROR, "File writing error", ex);
        }
    }

    public ArrayList<Client> readFromFile() {
        ArrayList<Client> clients = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/clients.txt")))
        {
            clients=((ArrayList<Client>)ois.readObject());
            ois.close();
        }
        catch(Exception ex){
            logger.log(Level.ERROR, "File reading error", ex);
        }
        return clients;
    }
}
