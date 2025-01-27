import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        
        // Variable to keep track of the closest sum
        int closestSum = Integer.MAX_VALUE;
        
        // Loop through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid unnecessary calculations
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Initialize two pointers for the other two elements
            int left = i + 1;
            int right = nums.length - 1;
            
            // Use the two-pointer technique to find the closest sum
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move the pointers based on the current sum comparison to the target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // If currentSum == target, return it immediately
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}
