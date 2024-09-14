class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        return numSubarray(nums, k) - numSubarray(nums, k - 1);

    }
     int numSubarray(vector<int>& nums, int k) {
        // The number of subarrays with exactly 'goal' sum is:
        // subarrays with sum <= goal - subarrays with sum < goal
       if(k < 0) return 0;
       int l = 0;
       int r = 0;
       int sum = 0;
       int n = nums.size();
       int cnt = 0;
      
       while(r < n){
           sum += (nums[r] % 2) ;
           while(sum > k){
            sum -= (nums[l] % 2) ;
            l++;
           }
           cnt += (r - l + 1);
           r++;
       } 
       return cnt;
    }
    
};