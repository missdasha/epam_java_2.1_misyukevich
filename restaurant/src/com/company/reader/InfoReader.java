package com.company.reader;

import com.company.information.Menu;

import javax.xml.soap.SAAJResult;
import java.io.InputStream;
import java.util.Scanner;

public class InfoReader {
    public static final String REGEX = "[0-4]";
    public static final String REGEX_NATURAL = "\\d+";
    public static final String REGEX_STRING = "\\s+";
    public int readInt(InputStream input){
        Scanner scanner = new Scanner(input);
        String line = scanner.nextLine();
        line = line.trim();
        while (!line.matches(REGEX)) {
            System.out.println("Choose correct option!");
            line = scanner.nextLine();
            line = line.trim();
        }
        int n = Integer.parseInt(line);
        return n;
    }

    public int readId(InputStream input){
        Scanner scanner = new Scanner(input);
        String line = scanner.nextLine();
        line = line.trim();
        while (!line.matches(REGEX_NATURAL)) {
            System.out.println("Choose natural number!");
            line = scanner.nextLine();
            line = line.trim();
        }
        int n = Integer.parseInt(line);
        return n;
    }

    public String[] readDish(InputStream input){
        Menu menu = new Menu();

        Scanner scanner = new Scanner(input);
        String line = scanner.nextLine();
        line = line.trim();
        String[] dishes = line.split(REGEX_STRING);
        for(String dish : dishes) {
            if(!menu.menu.containsKey(dish))
                return new String[0];
        }
        return dishes;
    }
}
