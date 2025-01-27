import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Loop through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Step 3: Skip duplicates for the 'i' element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 4: Use two pointers to find pairs that sum to the negative of nums[i]
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet, add it to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the 'left' pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for the 'right' pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers after processing the current pair
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If sum is less than zero, move the left pointer to the right
                    left++;
                } else {
                    // If sum is greater than zero, move the right pointer to the left
                    right--;
                }
            }
        }
        
        return result;
    }
}
