package polymorphism;

public class CompileTimePolymorphism {
    //Method Overloading

    void show(){
        int a =12, b =12;
        int c = a+b;
        System.out.println(c);
    }
    void show(int x, int y){
        int c = x + y;
        System.out.println(c);
    }
    void show(int x, int y, int z){
        int c = x + y + z;
        System.out.println(c);
    }

    public static void main(String[] args) {
        CompileTimePolymorphism obj = new CompileTimePolymorphism();
        obj.show(); obj.show(10,20); obj.show(10,20,30);
    }
}
