class Solution {
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}



/*
problem-title: "K Inverse Pairs Array"
problem-id: "629"
problem-link: "https://leetcode.com/problems/k-inverse-pairs-array/"

problem-level: "Hard"
problem-category: "Dynamic Programming"
problem-area: "Algorithm"
tags: ["Dynamic Programming"]

solving-strategy: "Dynamic Programming with prefix sums"
algorithm-name: "DP with prefix sum optimization"

core-idea: "Use a DP table where dp[i][j] represents the number of ways to arrange numbers 1 to i with exactly j inverse pairs."

observations:
  - "The number of inverse pairs in a permutation of n elements with all pairs as inverses is n(n-1)/2."
  - "For a fixed i, adding the number i to the permutation introduces new inverse pairs."

pattern-recognition:
  why-this-pattern: "This is a combination counting problem and is suitable for a dynamic programming approach with memory optimization."

alternative-approaches:
  - "Recursive approach with memoization."

why-not-alternatives: "Recursive approaches can lead to high time complexity and stack overflow issues."

window-details:
  window-type: "Sliding window over dynamic programming states."
  expand-condition: "Calculate prefix sums using dp[i-1][j] for optimization."
  shrink-condition: "Subtract the element dp[i-1][j-i] from prefix sum when appropriate."
  answer-update-condition: "Calculate the final dp value using prefix sums."

data-structures:
  - "2D Array for DP states."

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "dp[n][k]"

invariants:
  - "dp[i][0] is always 1 because there is one way (the sorted array) to arrange i elements with 0 inverse pairs."

edge-cases:
  - "k = 0, which should return 1 since only the sorted array has 0 inverses."
  - "k > n(n-1)/2, in which case should return 0 as it's not possible to have more inverse pairs."

dry-run-example: "For n=3 and k=1, initialize dp. Observe how dp is populated based on previous states."

complexity:
  time: "O(n * k)"
  space: "O(n * k)"

optimization:
  from: "O(n^2 * k^2) brute-force."
  to: "O(n * k) with optimized prefix sums."

mistakes-to-avoid:
  - "Avoid index out of bounds by ensuring j-i is non-negative."

implementation-notes:
  - "Use modular arithmetic correctly to handle negative numbers."

confidence: "High"
difficulty-reason: "Involves understanding dynamic programming transitions and prefix sum optimizations."

learning-outcome:
  - "Dynamic programming can be optimized with prefix sums to reduce nested loops."

similar-problems:
  - "Distinct Subsequences"

follow-up-questions:
  - "How will the solution adapt if there are additional constraints imposed on n and k?"

solution-summary: "The solution uses dynamic programming with prefix sum optimization to efficiently compute the number of arrays with exactly k inverse pairs."
*/
