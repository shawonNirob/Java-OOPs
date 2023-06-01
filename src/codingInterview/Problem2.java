package codingInterview;

//Write a function to calculate the sum of the first N natural numbers.
public class Problem2 {

    public int sumOfN(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }

    /*
    public int sumOfN(int n){
        return (n*(n+1))/2;
    }
     */

    public static void main(String[] args) {
        Problem2 sum = new Problem2();
        int result = sum.sumOfN(50);
        System.out.println(result);
    }
}
