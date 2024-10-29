class Solution {
    public int sumfunc(int[] nums, int threshold) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+= Math.ceil((double)nums[i]/(double)(threshold));
            
        }
        return sum;
        
        
    }
    int smallestDivisor(int[] nums, int limit){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1;
        int high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumfunc(nums,mid) <= limit){
                high=mid-1;
            } 
            else{
                low=mid+1;
            }
        }
        return low;
    }
}