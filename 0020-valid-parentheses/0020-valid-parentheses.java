 class Solution {
    public boolean isValid(String s) {
        // Stack to keep track of the opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse through the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If it's a closing bracket
            else {
                // Check if the stack is empty or the top doesn't match the corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        // If stack is empty, all the brackets were matched correctly
        return stack.isEmpty();
    }
}
