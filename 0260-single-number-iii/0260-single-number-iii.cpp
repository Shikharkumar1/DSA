class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        long XORR = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            XORR = XORR ^ nums[i];
        }
        int rightmost = XORR & (-XORR);
        int b1 = 0;
        int b2 = 0;
        for(int i = 0; i < n; i++) {
            if((nums[i] & rightmost) != 0) {
                b1 = b1 ^ nums[i];
            } else {
                b2 = b2 ^ nums[i];
            }
        }

        return {b1, b2};
    }
};
