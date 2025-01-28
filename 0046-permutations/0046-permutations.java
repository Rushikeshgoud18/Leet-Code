import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    // Backtracking function
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        // If the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current permutation
            return;
        }
        
        // Explore all options for the current position
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already in the current permutation
            if (current.contains(nums[i])) continue;
            
            current.add(nums[i]);
            backtrack(result, current, nums); // Recurse with the new element added
            current.remove(current.size() - 1); // Backtrack: remove the last element added
        }
    }
}
