class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            bool isEvenIndex = (mid % 2 == 0);

            if ((isEvenIndex && nums[mid] == nums[mid + 1]) || (!isEvenIndex && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
};
