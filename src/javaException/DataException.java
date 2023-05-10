package javaException;

public class DataException {
    public static void main(String[] args) {
        int a =16;
        try{
            int result = a/0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
