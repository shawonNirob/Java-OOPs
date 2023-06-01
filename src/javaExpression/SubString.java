package javaExpression;

public class SubString {
    public static void main(String args[]){
        String s="ShawonSarowarNirob";
        System.out.println("Original String: " + s);
        System.out.println("String length: " + s.length());
        System.out.println("Substring starting from index 6: " +s.substring(6));
        System.out.println("Substring starting from index 6 to 17: "+s.substring(6,17));

        System.out.println();
        String st="n";
        System.out.println("Original String: " + st);
        System.out.println("String length: " + st.length());
        System.out.println("Substring starting from index 0: " +st.substring(0));
        System.out.println("Substring starting from index : "+st.substring(1));
    }
}
