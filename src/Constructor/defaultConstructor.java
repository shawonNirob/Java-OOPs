package Constructor;

public class defaultConstructor {
    int number;
    int number2;
    public defaultConstructor (){
        number = 10;
        number2 = 20;
    }
    public void print(int n){
        for(int i=0; i<n; i++){
            System.out.print(i+ " ");
            System.out.print(number + number2);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        defaultConstructor call = new defaultConstructor();
        call.print(50);
    }
}
