class Solution {
    public int trap(int[] height) {
        int lmax=0 , rmax=0,total=0;
        int n = height.length;
        int  l=0 , r=n-1;
        
        while(l<=r){
            if(height[l] <= height[r]){
                if(lmax<=height[l]){
                    lmax=height[l];

                    
                }
                else{
                    total+=lmax-height[l];
                    
                }
                l++;
                
            }else{
                if(rmax<height[r]){
                    rmax=height[r];
                    
                }
                else{
                    total+=rmax-height[r];
                    
                    
                }
                r--;
            }
            
        }
        return total;
    }
}