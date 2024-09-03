class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n; // Use long to handle negative overflow
        if (nn < 0) nn = -1 * nn; // Make nn positive for processing
        
        while (nn > 0) { // Iterate while nn is positive
            if (nn % 2 != 0) { // If nn is odd, multiply the answer by x
                ans = ans * x;
                nn = nn - 1; // Decrement nn by 1
            } else { // If nn is even, square x and halve nn
                x = x * x;
                nn = nn / 2;
            }
        }
        
        if (n < 0) ans = 1.0 / ans; // If original n was negative, take reciprocal
        
        return ans; // Return the final answer
    }
}
