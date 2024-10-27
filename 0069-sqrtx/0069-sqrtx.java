class Solution {
    public int mySqrt(int x) {
        
        int low=0 , high=x;
        while(low<=high){
            long mid=(low+high)/2;
            long val=(mid*mid);
            if(val<=x){
                low=(int)mid+1;
            }
            else{
                high=(int)mid-1;
            }
            
        }
        return high;
        
    }
}