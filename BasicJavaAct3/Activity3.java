
import java.util.Scanner;

class Activity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = sc.nextInt();

        System.out.println("Sum: " + getSum(num1,num2));
        System.out.println("Difference: " + getDifference(num1,num2));
        System.out.println("Product: " + getProduct(num1,num2));

        sc.close();
    }

    public static int getSum(int a, int b) {
        return a + b;
    }
    public static int getDifference(int a, int b) {
        return a - b;
    }
    public static int getProduct(int a, int b) {
        return a * b;
    }
}