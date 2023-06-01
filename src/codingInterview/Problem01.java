package codingInterview;

public class Problem01 {
    public void mankey(int n, int x, double y){
        int up = 0;
        for(int i=1; i<n; i++){
            if(n%2==0) up +=x;
            if(n%2!=0) up -=y;
        }
        System.out.println(up);
    }

    public static void main(String[] args) {
        Problem01 sln = new Problem01();
        sln.mankey(10, 3, 1.2);
    }
}
