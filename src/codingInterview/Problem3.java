package codingInterview;

import java.util.Stack;

public class Problem3 {
    public boolean parenthesis(String s) {
        //Time = O(n);
        //Space = O(n);
        Stack<Character> stack = new Stack();

        for(int i=0; i<s.length(); i++){
            char chr = s.charAt(i);

            if(chr == '(' ) stack.push(')');
            else if(chr == '{' ) stack.push('}');
            else if(chr == '[' ) stack.push(']');
            else if(stack.isEmpty() || stack.pop() != chr) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem3 test = new Problem3();
        System.out.println(test.parenthesis("(){}[]"));
        System.out.println(test.parenthesis("(){[]"));
    }
}
