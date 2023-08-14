package Remotask;

// Course.java

import java.util.Scanner;

import java.util.Stack;

import java.util.Stack;

class Fibonacci{

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        int limit = 10;
        for (int i = 0; i < limit; i++) {
            System.out.println(fib(i));
        }
    }
}


