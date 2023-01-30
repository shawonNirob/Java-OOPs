package javaException;

public class RunTimeError {
    public static void main(String[] args) {
        int[] arr = {1,2,5,3,6};
        try {
            for(int i=-2; i<=arr.length; i++){
                System.out.println(arr[i]);
            }
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }
}
