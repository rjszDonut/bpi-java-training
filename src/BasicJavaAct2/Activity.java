package BasicJavaAct2;

import java.util.Scanner;

class Activity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age:");
        String age = sc.next();
        int ageInt = Integer.parseInt(age);
        double ageDouble = Double.parseDouble(age);

        System.out.println("Your Age as int, " + ageInt);
        System.out.println("Your Age as Double, " + ageDouble);

        sc.close();
    }
}