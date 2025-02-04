class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        int jumps = 0;
        int farthest = 0;
        int end = 0;
        
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            // When we reach the end of the current jump range
            if (i == end) {
                jumps++;
                end = farthest;
                
                // If we've already reached or exceeded the last index
                if (end >= n - 1) break;
            }
        }
        
        return jumps;
    }
}
