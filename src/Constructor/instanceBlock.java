package Constructor;

public class instanceBlock {
    int a, b;
    {
        //instance block
        //no name
        //call before constructor call
        //call during the object creation
        a = 10;
        b = 20;
        System.out.println(a+" "+b);
    }
    public instanceBlock(){
        a = 100;
        b = 200;
        System.out.println(a+" "+b);
    }
    static{
        //this is called without object during class creation
        System.out.println("this is static");
    }
    static void show(){
        //static method do not need a object;
        //and it can be called anytime, this is the advantage of it;
        //static method can not access the variable
        System.out.println("This is static method");
    }

    public static void main(String[] args) {
        instanceBlock.show();
        instanceBlock obj = new instanceBlock();
        instanceBlock.show();
    }
}
