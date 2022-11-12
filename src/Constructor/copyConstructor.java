package Constructor;

public class copyConstructor{
    public double var1, var2;
    public copyConstructor(double var1, double var2){
        this.var1 = var1;
        this.var2 = var2;
        System.out.println("default Constructor called: " + var1+" "+var2);
    }
    public copyConstructor(copyConstructor var){
        var1 = var.var1;
        var2 = var.var2;
        System.out.println("Copy Constructor called: " + var1+" "+var2);
    }

    public static void main(String[] args){
        copyConstructor call = new copyConstructor(65.10, 95.2);
        copyConstructor call2 = new copyConstructor(call);
    }
}
