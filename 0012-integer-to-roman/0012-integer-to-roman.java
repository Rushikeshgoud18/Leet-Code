class Solution {
    public String intToRoman(int num) {
        // Define the Roman numeral symbols and their corresponding values in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder(); // To store the Roman numeral
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                result.append(symbols[i]); // Append the corresponding symbol
                num -= values[i];          // Subtract the value from num
            }
        }
        return result.toString(); // Return the Roman numeral as a string
    }
}
