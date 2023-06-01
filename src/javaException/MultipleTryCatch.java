package javaException;


public class MultipleTryCatch {
    public static void main(String[] args){
        try{
            int a=20, c;
            int b=0; //b=2;
            c = a/b;
            System.out.println(c);

            int[] arr = {2,3,4,5};
            System.out.println(arr[0]);

            String str = null;
            //String str = "Nirob";
            System.out.println(str.toUpperCase());
            //int num = Integer.parseInt(str);
            //System.out.println(num);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Exception");

        }catch (ArithmeticException e){
            System.out.println("Artithmatic Exception");

        }catch (NumberFormatException e){
            System.out.println("Number format Exception");

        }catch (Exception e){
            System.out.println("All type of exception");
        }
    }
}
