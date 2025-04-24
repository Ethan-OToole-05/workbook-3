package com.pluralsight;

import javax.naming.Name;
import java.util.ArrayList;
import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        System.out.println("This is the following inventory available: ");
        for (Product product : inventory) {
            System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: $" + product.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        Product product = new Product();
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader reader = new BufferedReader(fileReader);
//            inventory.add(new Product(1234, "Hammer", 19.49f));
//            inventory.add(new Product(4321, "Clock", 14.99f));
//            inventory.add(new Product(1123, "Cake", 19.99f));
//            inventory.add(new Product(1334, "Computer", 199.99f));
//            inventory.add(new Product(1223, "Golf Clubs", 99.99f));
            String input;
            while ((input = reader.readLine()) != null) {
                String[] items = input.split("\\|");
                int id = Integer.parseInt(items[0]);
                String name = items[1];
                float price = Float.parseFloat(items[2]);

                inventory.add(new Product(id, name, price));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return inventory;
    }
}
