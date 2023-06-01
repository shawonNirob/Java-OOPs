package codingInterview;

public class LiveTest1{
    public int factIterative(int n){
        //Time -> O(n)
        //Space -> O(1)
        if(n==0) return 1;

        //need long based on the value of n
        int fact = n;
        while(n>1){
            fact = fact * (n-1);
            n--;
        }
        return fact;
    }
    public int factRecursion(int n){
        //Time -> O(n)
        //Space -> O(n)
        if(n==0 || n==1) return 1;

        return n * factRecursion(n-1);
    }

    public static void main(String[] args) {
        LiveTest1 test = new LiveTest1();
        System.out.println(test.factIterative(5));

        System.out.println(test.factRecursion(5));
    }
}
