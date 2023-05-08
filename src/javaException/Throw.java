package javaException;

public class Throw {
    public static void main(String[] args) {
        int numerator = 25;
        int denominator = 0;
        if (denominator == 0) {
            //throw new ArithmeticException("Cannot divide by zero");
        }
        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }
}
