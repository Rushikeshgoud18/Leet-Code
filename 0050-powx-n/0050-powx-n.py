class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # Handle the edge case where n is the minimum integer value (overflow issue)
        if n == -2147483648:
            return 1 / (self.myPow(x, 2147483647) * x)

        # Base case: if n is 0, return 1
        if n == 0:
            return 1.0

        # If n is negative, convert to positive
        if n < 0:
            x = 1 / x
            n = -n
        
        # Use binary exponentiation
        result = 1.0
        while n > 0:
            if n % 2 == 1:
                result *= x
            x *= x
            n //= 2  # Use integer division to ensure n is reduced correctly
        
        return result
