class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()  # Sort the list to make sure we can skip duplicates efficiently
        result = []
        n = len(nums)

        # Check if the length of the input array is less than 4
        if n < 4:
            return result  # No quadruplet possible

        # Iterate over the array to pick the first element
        for i in range(n - 3):
            # Skip duplicates for the first element
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # Iterate over the array to pick the second element
            for j in range(i + 1, n - 2):
                # Skip duplicates for the second element
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                # Use two pointers for the third and fourth elements
                left, right = j + 1, n - 1
                while left < right:
                    total = nums[i] + nums[j] + nums[left] + nums[right]
                    if total == target:
                        # If the sum matches the target, add the quadruplet to the result
                        result.append([nums[i], nums[j], nums[left], nums[right]])

                        # Skip duplicates for the third element
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        
                        # Skip duplicates for the fourth element
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1

                        # Move both pointers after finding a valid quadruplet
                        left += 1
                        right -= 1
                    elif total < target:
                        left += 1  # Need a larger sum, move the left pointer
                    else:
                        right -= 1  # Need a smaller sum, move the right pointer

        return result
