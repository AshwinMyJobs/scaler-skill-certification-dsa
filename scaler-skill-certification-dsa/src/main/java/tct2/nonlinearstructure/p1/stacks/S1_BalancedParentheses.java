package tct2.nonlinearstructure.p1.stacks;

import java.util.Stack;

public class S1_BalancedParentheses {
    public boolean solve(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // Step 1: Handle opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Step 2: Handle closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                        (ch == ']' && top == '[') ||
                        (ch == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // Step 3: Final validation check
        return stack.isEmpty();
    }
}
