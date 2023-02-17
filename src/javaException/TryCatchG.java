package javaException;

public class TryCatchG {
    public static void main(String[] args) {
        String str = "Nirob";
        //String str = "123";
        System.out.println(str);
        try{
            int num = Integer.parseInt(str);
            System.out.println(num);

            System.out.println("NumberFormatException");
        }catch (NumberFormatException n){
            System.out.println("String " + str+ " cant be converted into int");
        }

        System.out.println("Program Ended");
   }
}
