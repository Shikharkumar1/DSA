class Solution {
    // Helper method to find the maximum element in the array
    private int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    // Helper method to calculate total hours needed with a given eating speed
    private int findHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) v[i] / hourly);
        }
        return totalH;
    }

    // Main method to find the minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;  // Minimum possible speed
        int H = findMax(piles);  // Maximum possible speed

        while (l <= H) {
            int mid = (l + H) / 2;  // Calculate the middle speed
            int totalH = findHours(piles, mid);  // Calculate hours with current speed

            if (totalH > h) {  // If hours exceed limit, increase speed
                l = mid + 1;
            } else {  // Otherwise, try a lower speed
                H = mid - 1;
            }
        }
        return l;
    }
}
