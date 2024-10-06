class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            // If the current character is an opening bracket
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } 
            // If it's a closing bracket
            else {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }
                char top = stack.pop();

                // Check if it matches the correct opening bracket
                if ((currentChar == ')' && top != '(') ||
                    (currentChar == '}' && top != '{') ||
                    (currentChar == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        // If the stack is empty, all brackets were balanced
        return stack.isEmpty();
    }
}
