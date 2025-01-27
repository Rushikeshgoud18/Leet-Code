class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // This is to handle base case of valid substring starting at index 0
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  // Push the index of '('
            } else {
                stack.pop();  // Pop the top element for the current ')'
                if (stack.isEmpty()) {
                    stack.push(i);  // If stack is empty, push current index as base for next valid substring
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());  // Calculate the length of valid substring
                }
            }
        }
        return maxLength;
    }
}
