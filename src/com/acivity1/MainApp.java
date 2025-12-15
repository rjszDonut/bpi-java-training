package com.acivity1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    
    private static String[] productsArr = {"Laptop","Mouse","Keyboard", "Monitor", "Printer" };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> products = new ArrayList<>(); 

        // populate list
        System.out.println("All Products");
        for (int i = 0; i < productsArr.length; i++) {
            products.add(productsArr[i]);
            System.out.println((i+1) + ". " + products.get(i));
        }

        // remove mouse and add webcam
        System.out.println("After adding and removing Products");
        products.remove(1);
        products.add("Webcam");

        for (int i = 0; i < productsArr.length; i++) {
            // products.add(productsArr[i]);
            System.out.println((i+1) + ". " + products.get(i));

        }

        // find object
        System.out.print("Enter product name to search: ");
        String search = sc.nextLine();
        
        if (products.contains(search)) {
            System.out.println("Product found: " + search);
        } else {
            System.out.println("Product not found: " + search);
        }

        sc.close();
    }
}
