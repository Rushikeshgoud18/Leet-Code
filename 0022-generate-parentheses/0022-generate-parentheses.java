class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int openCount, int closeCount, int n) {
        // If the current string has reached the length of 2 * n, it's a valid combination
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        // We can add an opening parenthesis if we haven't used all opening parentheses
        if (openCount < n) {
            backtrack(result, current + "(", openCount + 1, closeCount, n);
        }
        
        // We can add a closing parenthesis if there are more opening than closing parentheses
        if (closeCount < openCount) {
            backtrack(result, current + ")", openCount, closeCount + 1, n);
        }
    }
}
