package codingInterview;

public class BigO {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=0; i<10; i++){
            sum+= callSum(i, i+1);
        }
        System.out.println(sum);
    }
    public static int callSum(int a, int b){
        return a+b;
    }
}
