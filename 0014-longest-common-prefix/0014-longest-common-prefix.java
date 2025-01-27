class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the input is empty
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume the first string is the longest common prefix initially
        String prefix = strs[0];

        // Compare the prefix with every string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it's a common prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Remove the last character of the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix
        return prefix;
    }
}
