#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;  // Check if the array is empty
        unordered_set<int> st;
        
        // Insert all elements into the set
        for (int i = 0; i < n; i++) {
            st.insert(nums[i]);
        }
        
        int longest = 0;

        // Iterate through the set
        for (auto it : st) {
            // Check if it is the start of a sequence
            if (st.find(it - 1) == st.end()) {
                int x = it;
                int currentStreak = 1;

                // Count the length of the consecutive sequence
                while (st.find(x + 1) != st.end()) {
                    x = x + 1;
                    currentStreak += 1;
                }

                longest = max(longest, currentStreak);
            }
        }

        return longest;
    }
};
