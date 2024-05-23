package codingInterview;

import superMethod.Main;

public class MinMx {

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,8,10,11,15,36,100};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x : arr){
            if(x<min) min =x;
            if(x>max) max =x;
        }

        System.out.println(min+" "+max);
    }
}
