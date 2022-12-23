package javaExpression;

public class StringToArray {
    public void test(String str){
        System.out.println(str);
        String[] arr = str.split("");
        System.out.println();
        for(String element: arr){
            System.out.println(element);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        String str = "How Are You?";
        StringToArray obj = new StringToArray();
        obj.test(str);
    }
}
