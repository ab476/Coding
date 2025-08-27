package ApnaCollege.StacksAndQueues;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() || !isSame(stack.peek(), ch)) {
                stack.add(ch);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private boolean isSame(char ch1, char ch2) {
        return switch(ch1) {
            case '(' -> ch2 == ')';
            case '{' -> ch2 == '}';
            case '[' -> ch2 == ']';
            default -> false;
        };
    }
}
