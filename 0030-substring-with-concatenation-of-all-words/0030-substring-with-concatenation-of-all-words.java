import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int word_len = words[0].length();
        int total_len = word_len * words.length;
        Map<String, Integer> word_count_map = new HashMap<>();
        
        // Populate the word count map
        for (String word : words) {
            word_count_map.put(word, word_count_map.getOrDefault(word, 0) + 1);
        }

        // Slide the window across the string s
        for (int i = 0; i < word_len; i++) {  // We check for all possible offsets in a word length
            int left = i;
            int right = i;
            Map<String, Integer> window_word_count = new HashMap<>();
            
            while (right + word_len <= s.length()) {
                String word = s.substring(right, right + word_len);
                right += word_len;

                // Only consider valid words in the window
                if (word_count_map.containsKey(word)) {
                    window_word_count.put(word, window_word_count.getOrDefault(word, 0) + 1);

                    // If we have too many occurrences of this word, move the left pointer
                    while (window_word_count.get(word) > word_count_map.get(word)) {
                        String left_word = s.substring(left, left + word_len);
                        window_word_count.put(left_word, window_word_count.get(left_word) - 1);
                        left += word_len;
                    }

                    // If the window size matches total_len, add the left index to the result
                    if (right - left == total_len) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if the current word is not valid
                    window_word_count.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
