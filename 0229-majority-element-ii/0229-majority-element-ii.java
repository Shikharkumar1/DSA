import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Step 1: Initialize variables
        int cnt1 = 0, cnt2 = 0; // Counters for the two potential majority elements
        Integer el1 = null, el2 = null; // Candidates for majority elements
        
        // Step 2: First pass - Find potential candidates
        for (int num : nums) {
            if (el1 != null && num == el1) { // Increment count for el1
                cnt1++;
            } else if (el2 != null && num == el2) { // Increment count for el2
                cnt2++;
            } else if (cnt1 == 0) { // Assign new candidate to el1
                el1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) { // Assign new candidate to el2
                el2 = num;
                cnt2 = 1;
            } else { // Decrement both counters
                cnt1--;
                cnt2--;
            }
        }

        // Step 3: Second pass - Verify counts of el1 and el2
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (el1 != null && num == el1) cnt1++;
            if (el2 != null && num == el2) cnt2++;
        }

        // Step 4: Check if the counts exceed n/3
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (cnt1 > threshold) result.add(el1);
        if (cnt2 > threshold) result.add(el2);

        return result;
    }
}
