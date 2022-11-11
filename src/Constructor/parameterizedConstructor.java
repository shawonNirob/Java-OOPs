package Constructor;

public class parameterizedConstructor {
    private int n1;
    private int n2;
    public parameterizedConstructor(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public void print(){
        for(int i=n1; i<n2; i++){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        parameterizedConstructor call = new parameterizedConstructor(4,9);
        call.print();
    }
}
