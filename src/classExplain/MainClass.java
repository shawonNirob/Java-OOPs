package classExplain;

public class MainClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.show();

        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.disp();
    }
}
