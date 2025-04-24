package com.pluralsight;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();


        System.out.println("This is the following inventory available: ");
        for(Product product : inventory) {
            System.out.println(product.getId() + product.getName() + product.getPrice());
        }
    }
    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();
//        try {
//            FileWriter fileWriter = new FileWriter("src/main/resources");
//            BufferedWriter writer = new BufferedWriter(fileWriter);
            inventory.add(new Product(1234, "Hammer", 19.49f));
            inventory.add(new Product(4321, "Clock", 14.99f));
            inventory.add(new Product(1123, "Cake", 19.99f));
            inventory.add(new Product(1334, "Computer", 199.99f));
            inventory.add(new Product(1223, "Golf Clubs", 99.99f));

//            writer.write();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }


        return inventory;
    }
}
