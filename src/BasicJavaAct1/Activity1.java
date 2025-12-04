package BasicJavaAct1;
import java.util.Scanner;

public class Activity1 {
    public static void main(String[] args) {
        String name = "";
        Scanner inputName = new Scanner(System.in);
        System.out.print("What is Your Name? ");

        name = inputName.next();

        System.out.println("HEllo, " + name + "!");

        inputName.close();
    }
}
