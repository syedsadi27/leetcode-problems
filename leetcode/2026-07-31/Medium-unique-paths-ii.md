# Unique Paths II (Medium)

https://leetcode.com/problems/unique-paths-ii/

## Solution (Python3)

```python3
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if not obstacleGrid or obstacleGrid[0][0] == 1:
            return 0
        
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        
        # Initialize DP table
        dp = [[0] * n for _ in range(m)]
        
        # Starting point
        dp[0][0] = 1
        
        # Fill the dp table
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0  # Obstacle cells
                else:
                    if i > 0:
                        dp[i][j] += dp[i-1][j]
                    if j > 0:
                        dp[i][j] += dp[i][j-1]
        
        return dp[m-1][n-1]
```

## Explanation

The solution uses dynamic programming to compute the number of unique paths to each cell. We initialize a grid `dp` where `dp[i][j]` represents the number of unique paths to position `(i, j)`. If a cell contains an obstacle, it contributes 0 paths.

1. Initialize the starting point `dp[0][0]` to 1 if it is not an obstacle.
2. Loop through each cell, updating `dp[i][j]` by accumulating paths from the top and the left.
3. If a cell is an obstacle, set `dp[i][j]` to 0.
4. Return the value at `dp[m-1][n-1]` for the answer.

The time complexity is O(m * n) since we process each cell once, and the space complexity is also O(m * n) due to the DP table.
