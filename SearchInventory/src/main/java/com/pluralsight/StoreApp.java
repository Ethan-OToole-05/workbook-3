package com.pluralsight;

import javax.naming.Name;
import java.util.*;
import java.io.*;

public class StoreApp {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        Scanner input = new Scanner(System.in);
        String clear;
        ArrayList<Product> inventory = getInventory();
        while(true) {
            try {
                display();
                System.out.print("Please enter a command: ");
                int command = input.nextInt();
                switch (command) {
                    case 1:
                        Collections.sort(inventory, Comparator.comparing(Product::getName));

                        System.out.println("This is the following inventory available: ");
                        for (Product product : inventory) {
                            System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: $" + product.getPrice());
                        }
                        break;
                    case 2:
                        Product product;
                        System.out.println("Please enter the product id: ");
                        int productid = input.nextInt();
                            for(Product item : inventory) {
                                if(item.getId() == productid) {
                                    System.out.println("ID: " + item.getId() + " Name: " + item.getName() + " Price: $" + item.getPrice());
                                    break;
                                }
                                //Add a not found for future use.
                            }
                            break;


                    default:
                        System.out.println("Thank you!");
                        System.exit(0);
                }
                clear = input.nextLine();
                System.out.print("Would you like to continue? (Y/N): ");
                String continueOption = input.nextLine().trim().toUpperCase();
                if(continueOption.charAt(0) != 'Y') {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                else {
                    continue;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
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
    public static void display() {
        System.out.println("What do you want to do?");
        System.out.println("1 - List all products");
        System.out.println("2 - Lookup a product by its id");
        System.out.println("3 - Find all products within a price range");
        System.out.println("4 - Add a new product");
        System.out.println("5 - Quit the application");
    }
}
