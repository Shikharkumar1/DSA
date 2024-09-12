class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int n = nums.size();
        int maxlen = 0;
        int l = 0, r = 0, zeros = 0;
        while (r < nums.size()) {
            if (nums[r] == 0) {
                zeros++;
            }
            if(zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            int len = r - l + 1;
            maxlen = max(len, maxlen);
            r++;
        }
        return maxlen;
    }
};