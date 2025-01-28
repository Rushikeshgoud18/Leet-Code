class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        // Result can be at most len1 + len2
        int[] result = new int[len1 + len2];
        
        // Multiply each digit
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // Multiply the digits and add to the corresponding position
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                
                result[i + j + 1] = sum % 10;  // Current position
                result[i + j] += sum / 10;     // Carry to next position
            }
        }
        
        // Build the result string
        StringBuilder sb = new StringBuilder();
        
        // Skip leading zeros
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        // If result is empty (case of 0 * 0), return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
