class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to help with duplicate handling
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));  // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                // Skip duplicates to avoid repeating combinations
                continue;
            }

            if (candidates[i] > target) break;  // No need to continue if the current number exceeds the target

            currentCombination.add(candidates[i]);
            // Recur with the next index (i + 1), because we cannot reuse the same number
            backtrack(candidates, target - candidates[i], i + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);  // Backtrack
        }
    }
}
