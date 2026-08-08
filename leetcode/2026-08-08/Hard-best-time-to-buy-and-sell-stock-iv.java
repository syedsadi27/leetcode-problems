class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);

        int[][] dp = new int[k+1][prices.length];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }

    private int quickSolve(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}



/*
problem-title: "Best Time to Buy and Sell Stock IV"
problem-id: "188"
problem-link: "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/"

problem-level: "Hard"
problem-category: "Dynamic Programming"
problem-area: ""
tags: []

solving-strategy: "Dynamic Programming with State Compression"
algorithm-name: "2D DP Array with Rolling Max Difference"

core-idea: "Use a 2D DP array to keep track of the maximum profit with up to i transactions by jth day."

observations:
  - "If k >= n/2, execute as many transactions as possible."
  - "DP equation for max profit with i transactions uses maxDiff."

pattern-recognition:
  why-this-pattern: "It aligns with state transition properties of stock buy/sell transactions."

alternative-approaches:
  - "Use a recursive approach with memoization."

why-not-alternatives: "Iterative DP with state compression is more space efficient and prevents stack overflow."

window-details:
  window-type: "Sliding window not applicable."
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "2D Array"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "dp[k][n-1]"

invariants:
  - "Optimal substructure maintained by DP transition function."

edge-cases:
  - "No prices to process (prices.length == 0)."
  - "k is large enough to act freely (k >= n/2)."

dry-run-example: "For k = 2, prices = [3,2,6,5,0,3], calculate dp array and follow maxDiff logic."

complexity:
  time: "O(k * n)"
  space: "O(k * n)"

optimization:
  from: "O(k * n^2) recursive solutions"
  to: "O(k * n) iterative DP solution"

mistakes-to-avoid:
  - "Not handling the case when k >= n/2 correctly."

implementation-notes:
  - "Ensure proper initialization of DP array and maxDiff."

confidence: "High"
difficulty-reason: "Involves understanding of dynamic programming for varying transaction limits."

learning-outcome:
  - "Learned to deal with transition states in DP for stock problems."

similar-problems:
  - "Best Time to Buy and Sell Stock"

follow-up-questions:
  - "How to modify the solution for transaction fees?"

solution-summary: "Implemented DP-based solution to calculate max profit with up to k transactions using 2D array and rolling max difference state."
*/
