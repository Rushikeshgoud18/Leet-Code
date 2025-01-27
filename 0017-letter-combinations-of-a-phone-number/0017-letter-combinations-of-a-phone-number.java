import java.util.*;

class Solution {
    // Mapping of digits to letters
    private final String[] phoneMap = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        // If the input is empty, return an empty list
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    // Backtracking function to generate all combinations
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // If the current combination length equals digits length, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the digit at the current index
        char digit = digits.charAt(index);
        // Get the corresponding letters for this digit
        String letters = phoneMap[digit - '0'];
        
        // Try each letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result); // Recurse to the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack, remove last added letter
        }
    }
}
