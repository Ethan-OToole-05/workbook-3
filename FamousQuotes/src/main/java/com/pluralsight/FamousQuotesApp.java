package com.pluralsight;

import java.util.Scanner;

public class FamousQuotesApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int index = 0;
        boolean run = true;
        String runOption = "", clear = "";
        String[] quotes = {"You miss 100% of the shots you don't take - Wayne Gretzky", "It is during our darkest moments that we must focus to see the light - Aristotle Onassis", "Try to be a rainbow in someone's cloud - Maya Angelou", "Behind every great man is a woman rolling her eyes. - Jim Carrey", "The best revenge is massive success - Frank Sinatra", "Never regret anything that made you smile - Mark Twain", "Get busy living or get busy dying - Andy Dufresne", "Live as if you were to die tomorrow - Mahatma Gandhi", "The time is always right to do what is right - Martin Luther King Jr.", "Everything you can imagine is real - Pablo Picasso"};
        System.out.println("Welcome to the quote giver!");
        while (run) {
            System.out.println("If you want a random quote input 11");
            System.out.print("Please input a number from 1-10 please: ");
            try {
                index = input.nextInt();
                if (index == 11) {
                    index = (int) (Math.random() * 10 + 1);
                }
                for(String quote : quotes) {
                    if(quote.equals(quotes[index])) {
                        System.out.println(quotes[index]);
                        break;
                    }
                    else {
                        continue;
                    }
                }

                clear = input.nextLine();
                System.out.print("Would you like another quote? (Y/N) ");
                runOption = input.nextLine().trim().toUpperCase();
                if(runOption.charAt(0) == 'Y') {
                    run = true;
                }
                else {
                    run = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input please try again.");
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Thank you for using the quote app!");
    }
}
