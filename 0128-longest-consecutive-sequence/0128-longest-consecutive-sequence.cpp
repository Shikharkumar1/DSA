class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;  // Early return if the list is empty
        
        unordered_set<int> st(nums.begin(), nums.end());  // Insert all elements into the set
        int longest = 0;

        for (int num : st) {
            // Only start counting if 'num' is the beginning of a sequence
            if (!st.count(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers starting from currentNum
                while (st.count(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longest = max(longest, currentStreak);  // Update the longest streak found
            }
        }

        return longest;
        
    }
};