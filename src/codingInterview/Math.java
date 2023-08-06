package codingInterview;

public class Math {
    public static void main(String[] args) {
        for(int i=1; i<100; i++){
            if(((11*i)+11)%13==0){
                System.out.println(i);
            }
        }
    }
}
