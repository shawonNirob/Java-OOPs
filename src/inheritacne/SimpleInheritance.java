package inheritacne;

import java.util.Scanner;

public class SimpleInheritance {
    int roll;
    String name;
    int marks;
    public void input(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter roll: ");
        roll = obj.nextInt();
        System.out.println("Enter name: ");
        name = obj.next();
        System.out.println("Enter marks: ");
        marks = obj.nextInt();
    }
}