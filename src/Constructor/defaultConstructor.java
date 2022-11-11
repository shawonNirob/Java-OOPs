package Constructor;

public class defaultConstructor {
    public void print(int n){
        for(int i=0; i<n; i++){
            System.out.print(i+ " ");
        }
    }
    public static void main(String[] args) {
        defaultConstructor call = new defaultConstructor();
        call.print(50);
    }
}
