class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowersNeeded = (long) m * k;
        if (totalFlowersNeeded > bloomDay.length) return -1;  // Impossible to make enough bouquets

        int minDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay, high = maxDay;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                high = mid - 1;  // Try for a smaller number of days
            } else {
                low = mid + 1;   // Increase the days
            }
        }
        return low;
    }

    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;  // Flower is ready, increase the count
                if (count == k) {  // If we have enough flowers for one bouquet
                    bouquets++;
                    count = 0;  // Reset the count for the next bouquet
                }
            } else {
                count = 0;  // Reset count if the flower isn't ready
            }
        }
        return bouquets >= m;
    }
}
