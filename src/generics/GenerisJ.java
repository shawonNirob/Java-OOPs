package generics;

public class GenerisJ <T>{
    T var;
    public GenerisJ(T var){
        this.var = var;
    }
    public void Print(){
        System.out.println(var);
    }
}
