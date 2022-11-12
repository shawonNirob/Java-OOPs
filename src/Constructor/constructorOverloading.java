package Constructor;

public class constructorOverloading{
    int a, b;
    public constructorOverloading(){
        a = 5;
        b = 6;
    }
    public constructorOverloading(int a){
         this.a = a;
         b = 34;
    }
    public constructorOverloading(int a, int b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        constructorOverloading call1 = new constructorOverloading();
        constructorOverloading call2 = new constructorOverloading(25);
        constructorOverloading call3 = new constructorOverloading(200,300);

        System.out.println(call1.a+" "+call1.b);
        System.out.println(call2.a+" "+call2.b);
        System.out.println(call3.a+" "+call3.b);

    }
}
