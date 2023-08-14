package codingInterview;

public class LiveTest4 {
    public boolean ifPalindrome(String s){
        return helper(s, 0,  s.length()- 1);
    }
    public boolean helper(String s, int l, int r){
        if(l>=r){
            return true;
        }

        if(s.charAt(l) != s.charAt(r)) {
            return false;
        }

        return helper(s, l+1, r-1);
    }

    public static void main(String[] args) {
        LiveTest4 test =new LiveTest4();
        System.out.println(test.ifPalindrome("madam"));
    }
}
