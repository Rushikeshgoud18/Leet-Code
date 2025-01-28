import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    // Backtracking function
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // If the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current permutation
            return;
        }
        
        // Explore all options for the current position
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used or it's a duplicate of the previous element and hasn't been used
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            
            used[i] = true;
            current.add(nums[i]);
            backtrack(result, current, nums, used); // Recurse with the new element added
            current.remove(current.size() - 1); // Backtrack: remove the last element added
            used[i] = false; // Backtrack: mark the element as unused
        }
    }
}
