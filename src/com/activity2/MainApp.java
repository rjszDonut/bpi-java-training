package com.activity2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApp {
    private static char choice;
    private static String[] productsArr = {"Laptop","Monitor","Mouse","Keyboard", "Printer" };
    private static String query;
    private static int productsSize;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> products = new HashSet<>();


        for (int i = 0; i < productsArr.length; i++) {
            products.add(productsArr[i]);
        }
        
        
        do {
            System.out.println("\n1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Select item: ");
            choice = sc.next().charAt(0);

            sc.nextLine();
            switch (choice) {
                case '1':
                    System.err.print("\nEnter product name to search: ");
                    query = sc.nextLine();
                    if(products.contains(query)) {
                        System.err.println("Product found: " + query);
                    }else {
                        System.err.println("Product not found: " + query);
                    }
                
                    break;
                case '2':
                    System.err.print("\nEnter product name to add: ");
                    query = sc.nextLine();
                    products.add(query);
                    System.err.print("Product added: "+ query);

                    break;
                case '3':
                    System.err.println("\nAll Products: ");
                    for (String product : products) {
                        System.out.println(product);
                    }
                    productsSize = products.size();
                    System.out.println("Total unique products: " + productsSize);
                    break;
                case '4':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            
                }
        } while (choice != '4');
        sc.close();
    }
}
