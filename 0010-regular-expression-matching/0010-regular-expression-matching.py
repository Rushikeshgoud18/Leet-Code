class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # Initialize the DP table with False values
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        
        # Base case: Empty string matches empty pattern
        dp[0][0] = True
        
        # Handle patterns like "a*", ".*", etc., that can match an empty string
        for j in range(1, len(p) + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]  # If the '*' means zero occurrences of the character before it
        
        # Fill the DP table
        for i in range(1, len(s) + 1):
            for j in range(1, len(p) + 1):
                if p[j - 1] == s[i - 1] or p[j - 1] == '.':
                    dp[i][j] = dp[i - 1][j - 1]  # Characters match or wildcard '.'
                elif p[j - 1] == '*':
                    # Case 1: Zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2]
                    # Case 2: One or more occurrences of the preceding character
                    if p[j - 2] == s[i - 1] or p[j - 2] == '.':
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
        
        return dp[len(s)][len(p)]  # The result is in the bottom-right corner of the DP table
