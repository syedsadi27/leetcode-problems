# Best Time to Buy and Sell Stock IV (Hard)

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

## Solution (Python3)

```python3
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        if not prices or k == 0:
            return 0
        n = len(prices)
        
        # If k is large enough, it's equivalent to unlimited transactions
        if k >= n // 2:
            return sum(max(prices[i + 1] - prices[i], 0) for i in range(n - 1))

        # Dynamic programming
        # dp[i][j] = max profit using at most i transactions up to day j (0-indexed)
        dp = [[0] * n for _ in range(k + 1)]

        for i in range(1, k + 1):
            max_diff = -prices[0]
            for j in range(1, n):
                dp[i][j] = max(dp[i][j - 1], prices[j] + max_diff)
                max_diff = max(max_diff, dp[i - 1][j] - prices[j])

        return dp[k][n - 1]
```

## Explanation

The solution uses dynamic programming to calculate the maximum profit. The idea is to maintain a table `dp` where `dp[i][j]` represents the maximum profit achievable with at most `i` transactions up to day `j`.

1. If `k` is large (≥ n/2), any transaction restriction is lifted because unlimited transactions are possible, and the problem reduces to the one where we can just sum up every positive difference.

2. Otherwise, for each number of transactions from 1 to k, and each day, we calculate the maximum profit by considering two options:
   - Not trading on the j-th day (carry forward the previous day's profit)
   - Selling on the j-th day, which requires calculating the maximum potential profit with one less transaction on any of the previous days minus that day's price.

3. The key component here is maintaining `max_diff`, which tracks the difference between the profits up to the previous transaction and prices, ensuring we choose the best previous day to base the current transaction on.

Time Complexity: O(n*k), where n is the length of prices and k is the maximum number of transactions.
Space Complexity: O(n*k) for the dp table.
