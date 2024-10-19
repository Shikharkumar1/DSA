import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        // Traverse through each character of the string
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            // Pop from stack while the current char is smaller than the top of the stack
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }

            // Avoid pushing leading zeros unless the stack is empty
            if (!st.isEmpty() || c != '0') {
                st.push(c);
            }
        }

        // If k > 0, pop remaining digits from the stack
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the result from the stack
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Reverse the result to get the correct order
        res.reverse();

        // If the result is empty after removing leading zeros, return "0"
        return res.length() == 0 ? "0" : res.toString();
    }
}
