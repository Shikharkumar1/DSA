class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
        
    }
     public long sumSubarrayMins(int[] arr) {
        int[] nextSm = nextSmaller(arr);
        int[] prevSm = prevSmaller(arr);
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            int first = i - prevSm[i];
            int second = nextSm[i] - i; 
            long total = (first * second); 
            total = (total * arr[i]); 
            count = (count + total); 
        }
        
        return count; 
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

     public long sumSubarrayMaxs(int[] arr) {
        int[] nextGt = nextGreater(arr);
        int[] prevGt = prevGreater(arr);
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            int first = i - prevGt[i];
            int second = nextGt[i] - i; 
            long total = (first * second); 
            total = (total * arr[i]); 
            count = (count + total); 
        }
        
        return count; 
    }

    private int[] nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>(); 
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) 
        {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        
        return ans; // Return the result
    }

    private int[] prevGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return ans;
    }
}



    
