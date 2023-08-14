package codingInterview;

public class Assignment04 {

    //Time == O(n);
    //Space == O(n);
    public int multiply(int a, int b){
        if(b==0) return 0;
        else return a + multiply(a, b-1);
    }
    /*
    public int multiply(int a, int b){
        if(a==0) return 0;
        else return b + multiply(a-1, b);
    }
     */

    public static void main(String[] args) {
        Assignment04 asgn = new Assignment04();
        System.out.println(asgn.multiply(4,5));
    }
}
