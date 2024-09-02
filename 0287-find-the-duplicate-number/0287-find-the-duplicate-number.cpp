class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        // Initial pointers
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Finding the intersection point of the two runners
        do {
            slow = nums[slow];        // Moves one step
            fast = nums[nums[fast]];  // Moves two steps
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;  // Duplicate number
    }
};
