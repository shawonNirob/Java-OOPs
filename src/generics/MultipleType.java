package generics;

public class MultipleType<X, Y> {
    private X var1;
    private Y var2;
     public MultipleType(X var1, Y var2){
         this.var1 = var1;
         this.var2 = var2;
     }

     public X getvar1(){
         return var1;
     }
     public Y getVar2(){
         return var2;
     }

     public void showType(){
         System.out.println("Type of X is: "+ var1.getClass().getName()+" value is "+ var1);
         System.out.println("Type of Y is: "+ var2.getClass().getName()+" value is "+ var2);
     }

    public static void main(String[] args) {
        MultipleType<String, String> case1 = new MultipleType<>("Nirob","Boss");
        case1.showType();

        MultipleType<String, Integer> case2 = new MultipleType<>("Nirob", 180);
        case2.showType();

        MultipleType<Double, Integer> case3 = new MultipleType<>(365.25, 180);
        case3.showType();

        MultipleType<String, MultipleType<Integer, Double>> typeInsideType = new MultipleType<>("Nirob", new MultipleType<>(365,100.0001));
        typeInsideType.showType();
    }
}
