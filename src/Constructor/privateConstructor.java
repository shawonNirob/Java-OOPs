package Constructor;

public class privateConstructor {
    int a, b;
    private privateConstructor(){
        a=19;
        b=20;
        System.out.println(a+" "+b);
    }

    public static void main(String[] args) {
        privateConstructor call = new privateConstructor();
    }
}
