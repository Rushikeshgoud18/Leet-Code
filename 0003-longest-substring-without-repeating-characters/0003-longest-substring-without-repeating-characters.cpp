class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> seen; // Hash set to store characters in the current window
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // To track the maximum length of the substring without repeating characters

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); ++right) {
            // If the character is already in the set, move the left pointer
            while (seen.count(s[right])) {
                seen.erase(s[left]);
                left++; // Shrink the window from the left
            }
            
            // Add the current character to the set
            seen.insert(s[right]);
            
            // Update the maximum length of the substring
            maxLength = max(maxLength, right - left + 1);
        }

        return maxLength; // Return the length of the longest substring
    }
};
