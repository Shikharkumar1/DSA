class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int n = nums.size();
        vector<int> fr(n + 1, 0);
        for (int i = 0; i < n; i++) {
            if (fr[nums[i]] == 0) {
                fr[nums[i]] += 1;
            }else{
                return nums[i];
            }
        } return 0;
    }
};