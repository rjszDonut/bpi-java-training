package BasicJavaAct4;


import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age < 18) {
            System.out.println("Minor");
        } else if (age > 60) {
            System.out.println("Senior");
        }else {
            System.out.println("Adult");
        }

    sc.close();
    }
   
}
