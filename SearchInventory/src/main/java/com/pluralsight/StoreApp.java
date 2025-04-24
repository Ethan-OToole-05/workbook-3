package com.pluralsight;

import java.util.*;
import java.io.*;

public class StoreApp {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        Scanner input = new Scanner(System.in);
        String clear;
        ArrayList<Product> inventory = getInventory();
        while (true) {
            try {
                //Displays user interface with options.
                display();
                System.out.print("Please enter a command: ");
                String commandInput = input.nextLine();
                int command = Integer.parseInt(commandInput);
                switch (command) {
                    case 1:
                        //Prints out every product in inventory.
                        Collections.sort(inventory, Comparator.comparing(Product::getName));

                        System.out.println("This is the following inventory available: ");
                        for (Product product : inventory) {
                            System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: $" + product.getPrice());
                        }
                        break;
                    case 2:
                        //Searches for a product by a product id number.
                        System.out.println("Please enter the product id: ");
                        String productIdInput = input.nextLine();
                        int productId = Integer.parseInt(productIdInput);
                        for (Product product : inventory) {
                            if (product.getId() == productId) {
                                System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: $" + product.getPrice());
                                break;
                            }
                            //Add a not found for future use.
                        }
                        break;
                    case 3:
                        //Will print out products that are between a minimum price, and maximum price.
                        System.out.print("Please enter a number for a price range: (Minimum:Maximum): ");
                        String range = input.nextLine();
                        String[] prices = range.split(":");
                        float minValue, maxValue;
                        minValue = Float.parseFloat(prices[0]);
                        maxValue = Float.parseFloat(prices[1]);
                        for (Product product : inventory) {
                            if (minValue <= product.getPrice() && product.getPrice() < maxValue) {
                                System.out.println("ID: " + product.getId() + " Name: " + product.getName() + " Price: $" + product.getPrice());
                            }
                        }
                        break;
                    case 4:
                        //Writes a new product to the inventory. *Need to add a FileWriter feature
                        Product product;
                        System.out.print("Please enter the new product name and price (Name:Price): ");
                        String newProductInfo = input.nextLine();
                        String[] info = newProductInfo.split(":");
                        int id;
                        String name;
                        float price;
                        id = (int) (Math.random() * 1000) + 1;
                        name = info[0];
                        price = Float.parseFloat(info[1]);
                        inventory.add(new Product(id, name, price));
                        System.out.println("Created product.");
                        break;
                    //Any other option will stop the program.
                    default:
                        System.out.println("Thank you!");
                        System.exit(0);
                }

                clear = input.nextLine();
                //Continue option displayed for the user.
                System.out.print("Would you like to continue? (Y/N): ");
                String continueOption = input.nextLine().toUpperCase();
                if (continueOption.charAt(0) != 'Y') {
                    System.out.println("Thank you!");
                    System.exit(0);
                } else {
                    continue;
                }
            } catch (Exception e) {
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
            reader.close();
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
