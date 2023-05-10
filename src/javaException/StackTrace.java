package javaException;

public class StackTrace {
    public static int divide(int a, int b){
        return a/b;
    }
    public static void main(String[] args) {
        int a=10, b=0;
        int result = divide(a,b);

        System.out.println("Result: "+a+"/"+b+"="+result);
    }
}
