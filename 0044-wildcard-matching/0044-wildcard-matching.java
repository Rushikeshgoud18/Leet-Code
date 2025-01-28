class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table to store the results of subproblems
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty pattern matches empty string
        dp[0][0] = true;
        
        // If the pattern is only "*" characters, they can match the empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '?') {
                    // If characters match or it's a '?', carry over the previous match state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' can match empty sequence or one or more characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        // The result is stored in dp[m][n], which is whether the entire string s matches pattern p
        return dp[m][n];
    }
}
