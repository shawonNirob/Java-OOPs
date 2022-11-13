package thisKeyword;

public class ThisRefer {
    public ThisRefer(){
        this(100);
        System.out.println("default constructor");
    }
    public ThisRefer(int a){
        System.out.println(a);
    }
    /*public void show(){
        System.out.println(a);
    }

     */
    public static void main(String[] args) {
        ThisRefer obj = new ThisRefer();
        //obj.show ();
    }
}
