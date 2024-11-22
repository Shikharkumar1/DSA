#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countSplits(vector<int> &nums, int maxSumAllowed) {
        int splits = 1; // At least one split is needed
        long long currentSum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (currentSum + nums[i] <= maxSumAllowed) {
                currentSum += nums[i];
            } else {
                splits += 1;
                currentSum = nums[i];
            }
        }
        return splits;
    }

    int splitArray(vector<int>& nums, int k) {
        int low = *max_element(nums.begin(), nums.end());
        int high = accumulate(nums.begin(), nums.end(), 0);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int splits = countSplits(nums, mid);

            if (splits > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};
