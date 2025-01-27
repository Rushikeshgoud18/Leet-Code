class Solution {
    public String countAndSay(int n) {
        // Start with the base case
        String result = "1";
        
        // Iterate to build the sequence from countAndSay(2) to countAndSay(n)
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            // Traverse through the string to apply run-length encoding
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            // Append the last sequence
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();  // Update result to the next term
        }
        
        return result;
    }
}
