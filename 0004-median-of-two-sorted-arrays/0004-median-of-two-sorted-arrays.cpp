class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.size() > nums2.size()) {
            swap(nums1, nums2);
        }

        int m = nums1.size(), n = nums2.size();
        int left = 0, right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // Get the maximum and minimum values on both sides of the partitions
            int maxLeft1 = (partition1 == 0) ? INT_MIN : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? INT_MAX : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? INT_MIN : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? INT_MAX : nums2[partition2];

            // Check if we've found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the combined length is odd, the median is the max of the left parts
                if ((m + n) % 2 == 1) {
                    return max(maxLeft1, maxLeft2);
                }
                // If the combined length is even, the median is the average of the two middle elements
                return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0;
            }
            // Adjust the binary search range
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        // If we reach here, it means the input arrays are not sorted correctly (not possible as per problem constraints)
        throw invalid_argument("Input arrays are not sorted.");
    }
};
