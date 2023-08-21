package AI;
public class fibonacci {
    public static void main(String[] args) {
        try {
            System.out.println("math Problem");
            int a = 20;
            int b = 0;
            int c = a / b;
            System.out.println(c);
            System.out.println("program successfully done");
        } catch (ArithmeticException e) {
            System.out.println("This cant be solve");
        } finally {
            System.out.println("program running");
        }
        System.out.println("program ended");
    }
}
