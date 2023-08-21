package dp;

import java.util.Arrays;

public class Fibonacci {

    /*
    //Normal recursion
    public int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;


        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(6));
    }
     */

    /*
    //memoization - Top down approach
    public int fib(int n, int[] arr){
        if(n==0) return 0;
        if(n==1) return 1;
        if(arr[n] != -1) return arr[n];

        arr[n] = fib(n-1, arr)+fib(n-2, arr);

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(n, arr));
    }
     */

    //Tabulation - Bottom Up approach
    //
    public int fib(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 6;
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(n));
    }
}
