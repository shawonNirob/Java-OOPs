package classExplain;

public class OuterClass {
    int number = 10;
    public void show(){
        System.out.println("This is outerClass and "+"number = "+number);
    }
    public class InnerClass{
        int number = 20;
        public void disp(){
            System.out.println("This is outerClass and "+"number = "+number);
        }
    }
}
