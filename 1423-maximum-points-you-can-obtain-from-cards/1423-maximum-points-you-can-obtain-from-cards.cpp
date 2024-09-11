class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        int lsum = 0, rsum = 0, maxsum = 0;

        // Calculate the sum of the first k elements from the left
        for (int i = 0; i < k; i++) {
            lsum = lsum + cardPoints[i];
        }

        // Set the initial maximum sum as the sum of the left elements
        maxsum = lsum;
        int rindex = n - 1;

        // Sliding window from right end, adding right elements and removing left elements
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - cardPoints[i];     // Subtract the current element from left sum
            rsum = rsum + cardPoints[rindex]; // Add the element from the right end to the right sum
            rindex = rindex - 1;

            // Update the maxsum with the current combination of lsum and rsum
            maxsum = max(maxsum, lsum + rsum);
        }
        
        return maxsum;
    }
};
