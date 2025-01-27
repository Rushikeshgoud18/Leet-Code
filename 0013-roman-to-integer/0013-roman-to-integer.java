class Solution {
    public int romanToInt(String s) {
        // Define a map for Roman numeral symbols and their corresponding values
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // If current symbol is less than next symbol, subtract its value
            if (i < n - 1 && romanToIntMap.get(s.charAt(i)) < romanToIntMap.get(s.charAt(i + 1))) {
                result -= romanToIntMap.get(s.charAt(i));
            } else {
                // Otherwise, add its value
                result += romanToIntMap.get(s.charAt(i));
            }
        }
        
        return result;
    }
}
