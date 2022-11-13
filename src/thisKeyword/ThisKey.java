package thisKeyword;

public class ThisKey {
    public void show(){
        System.out.println(this);
    }
    public static void main(String[] args) {
        ThisKey obj = new ThisKey();
        System.out.println(obj);
        obj.show();
    }
}
