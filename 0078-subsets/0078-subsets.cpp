class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();  // 2^n subsets
        vector<vector<int>> subsets_list;
        
        for (int num = 0; num < (1<<n); num++) {
            vector<int> subset;
            for (int i = 0; i < n; i++) {
                if (num & (1 << i)) {
                    subset.push_back(nums[i]);
                }
            }
            subsets_list.push_back(subset);
        }
        
        return subsets_list;
    }
};