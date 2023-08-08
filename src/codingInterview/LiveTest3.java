package codingInterview;

public class LiveTest3 {

    public String suffle(String s, int[] indices){
        char[] chr = new char[indices.length];
        for(int i=0; i<s.length(); i++) {
            chr[indices[i]] = s.charAt(i);
        }
        return new String(chr);
    }

    public static void main(String[] args) {
        LiveTest3 test = new LiveTest3();
        System.out.println(test.suffle("mamacode", new int[]{4, 5, 6, 7, 0, 1, 2, 3}));
    }
}
