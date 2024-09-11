#include <map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Initialize hash map to store the last seen index of each character
        map<char, int> hash; 
        
        int left = 0, right = 0, maxlen = 0;
        int n = s.size();
        int len = 0;
        
        // Use a sliding window approach
        while (right < n) {
            // If the character has been seen before and its last seen index is within the current window
            if (hash.count(s[right]) && hash[s[right]] >= left) {
                left = hash[s[right]] + 1;  // Move the left pointer to the right of the last seen index
            }
            
            // Update the hash with the current index of the character
            hash[s[right]] = right;

            // Calculate the current window length
            len = right - left + 1;
            maxlen = max(maxlen, len);  // Update maxlen if the current length is greater
            
            right++;
        }
        return maxlen;
    }
};
