class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0; // Initialize element to track majority

        // First pass to find the candidate for the majority element
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) { 
                el = nums[i]; // Set potential majority element
                cnt = 1;
            } else if (el == nums[i]) {
                cnt++; // Increase count if the element matches
            } else {
                cnt--; // Decrease count otherwise
            }
        }

        // Second pass to verify if the candidate is actually the majority
        cnt = 0; // Reset count
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                cnt++;
            }
        }

        // Optional: Check if the count exceeds half of the array length
        if (cnt > nums.length / 2) {
            return el; // Majority element found
        }

        // If the input guarantees a majority element, this check is not necessary
        return -1; // Return -1 if no majority element is found (in case of validation)
    }
}
