package testing;

import java.util.Scanner;

public class Test {
    static String name;
    static int id;
    static String department;
    public static void show(){
        System.out.println(name+" "+id+" "+department);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your name, id and department: ");
        name = obj.nextLine();
        id = obj.nextInt();
        department = obj.next();

        Test.show();
    }
}
