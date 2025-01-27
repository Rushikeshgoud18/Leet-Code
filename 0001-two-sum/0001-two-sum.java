class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers we've seen and their indices
        HashMap<Integer, Integer> seen = new HashMap<>();
        
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement
            
            // Check if the complement exists in the HashMap
            if (seen.containsKey(complement)) {
                // If it does, return the indices of the two numbers
                return new int[] {seen.get(complement), i};
            }
            
            // Otherwise, store the current number and its index
            seen.put(nums[i], i);
        }
        
        // Since the problem guarantees a solution, we won't need to return anything here.
        // But in case of no solution, we could return an empty array or some other value.
        return new int[] {};
    }
}
