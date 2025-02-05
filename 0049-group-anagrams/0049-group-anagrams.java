import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the anagram groups
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate over each string in the input array
        for (String str : strs) {
            // Sort the string to use as a key (canonical form of the anagram group)
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the key doesn't exist in the map, initialize it with an empty list
            map.putIfAbsent(sortedStr, new ArrayList<>());
            
            // Add the current string to the corresponding list in the map
            map.get(sortedStr).add(str);
        }
        
        // Return all the lists of anagrams as the result
        return new ArrayList<>(map.values());
    }
}
