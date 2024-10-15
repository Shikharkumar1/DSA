import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSm = nextSmaller(arr);
        int[] prevSm = prevSmaller(arr);
        int mod = 1000000007;
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            int first = i - prevSm[i];
            int second = nextSm[i] - i; 
            long total = (first * second) % mod; 
            total = (total * arr[i]) % mod; 
            count = (count + total) % mod; 
        }
        
        return (int) count; 
    }

    private int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>(); 
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) 
        {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        
        return ans; // Return the result
    }

    private int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return ans;
    }
}
