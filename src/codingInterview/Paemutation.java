package codingInterview;

public class Paemutation {
    void permutaion(String str){
        per(str, "");
    }
    void per(String str, String prefix){
        if(str.length()==0){
            System.out.println(prefix);
        }else{
            for(int i=0; i<str.length(); i++){
                String rem = str.substring(0, i)+ str.substring(i + 1);
                per(rem, prefix+str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Paemutation call = new Paemutation();
        call.permutaion("Nirob");
    }

}
