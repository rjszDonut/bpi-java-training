package com.activity3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {
    private static char choice;
    private static String[] productsArr = {"Laptop","Monitor","Mouse","Keyboard", "Printer" };
    private static Integer[] productsPriceArr = {10000,1500,900,1200, 12000 };

    private static String query;
    private static int productsSize;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> products = new HashMap<>();

        for (int i = 0; i < productsArr.length; i++) {
            products.put(productsArr[i], productsPriceArr[i]);
        }
        
        do {
            System.out.println("\n1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Find cheapest product");
            System.out.println("5. Exit");
            System.out.print("Select item: ");
            choice = sc.next().charAt(0);

            sc.nextLine();
            switch (choice) {
                case '1':
                    System.err.print("\nEnter product name to search: ");
                    query = sc.nextLine();
                    if(products.containsKey(query)) {
                        System.err.println("Product found: " + query);
                    }else {
                        System.err.println("Product not found: " + query);
                    }
                
                    break;
                case '2':
                    System.err.print("\nEnter product name to add: ");
                    query = sc.next();
                    System.err.print("\nEnter product's price: ");
                    Integer price = sc.nextInt();
                    products.put(query, price);
                    System.err.print("Product added: "+ query);

                    break;
                case '3':
                    System.err.println("\nPrint all Products and prices: ");
                    for(Map.Entry<String, Integer> entry : products.entrySet()){
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                    }
                    productsSize = products.size();
                    System.out.println("Total unique products: " + productsSize);
                    break;
                case '4':
                    String cheapestProduct = null;
                    Integer cheapestPrice = null; // or use Integer.MAX_VALUE

                    for (Map.Entry<String, Integer> entry : products.entrySet()) {
                        String name = entry.getKey();
                        price = entry.getValue();
                  
                        if (cheapestPrice == null || price < cheapestPrice) {
                            cheapestPrice = price;
                            cheapestProduct = name;
                        }
                    }
                
                    System.out.println("Cheapest product: " + cheapestProduct + " at " + cheapestPrice);
                    break;

                case '5':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice\n");
                    break;
            
                }
        } while (choice != '5');
        sc.close();
    }
}
