package hierarchicalInheritance;

public class Demo {
    public static void main(String[] args) {
        Mahin call1 = new Mahin();
        Akash call2 = new Akash();
        Nirob call3 = new Nirob();

        call3.show(); call3.dispN();
        call2.show(); call2.dispA();
        call1.show(); call1.dispM();
    }
}
