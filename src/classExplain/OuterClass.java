package classExplain;

public class OuterClass {
    int number = 10;
    public void show(){
        System.out.println("This is outerClass and "+"number = "+number);

        class LocalInnerClass{
            public void lIC() {
                System.out.println("This is local innerClass");
            }
        }

        LocalInnerClass lic = new LocalInnerClass();
        lic.lIC();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.show();

        //OuterClass.InnerClass inner = new OuterClass.InnerClass();
        InnerClass inner = new InnerClass();
        inner.disp();
    }
}
