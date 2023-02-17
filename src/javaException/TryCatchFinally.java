package javaException;

public class TryCatchFinally {
    public static void main(String[] args) {
        try{
            System.out.println("math Problem");
            int a=20, c;
            int b=0; //b=2;
            c = a/b;
            System.out.println(c);
            System.out.println("program successfully done");
        }catch (ArithmeticException e){
            System.out.println("This cant be solve");
        }finally {
            //This is always terminate
            System.out.println("program running");
        }

        System.out.println("program ended");
    }
}
