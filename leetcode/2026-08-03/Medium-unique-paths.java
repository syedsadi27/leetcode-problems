class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}



/*
problem-title: "Unique Paths"
problem-id: "62"
problem-link: "https://leetcode.com/problems/unique-paths/"

problem-level: "Medium"
problem-category: "Dynamic Programming"
problem-area: "Algorithms"
tags: ["Dynamic Programming", "Combinatorics"]

solving-strategy: "Bottom-up Dynamic Programming"
algorithm-name: "Dynamic Programming Table"

core-idea: "Use a 2D DP array to store the number of ways to reach each cell."

observations:
  - "The robot can only move right or down."
  - "The number of ways to reach a cell is the sum of ways from the top and left cells."

pattern-recognition:
  why-this-pattern: "Each cell depends only on its top and left neighbors, fitting the DP paradigm."

alternative-approaches:
  - "Recursive approach with memoization"

why-not-alternatives: "Recursive approaches might lead to stack overflow and are generally less efficient."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "2D DP array"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "dp[m-1][n-1]"

invariants:
  - "dp[i][j] stores the number of unique paths to reach that cell."

edge-cases:
  - "Minimum grid size 1x1."
  - "Rectangular and square grids."

dry-run-example: "For a 3x3 grid, compute dp[2][2] = dp[1][2] + dp[2][1]."

complexity:
  time: "O(m * n)"
  space: "O(m * n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not initializing the first row and first column correctly."

implementation-notes:
  - "Ensure iterative filling of the DP table."

confidence: "High"
difficulty-reason: "Standard DP problem with clear subproblem dependencies."

learning-outcome:
  - "How to apply dynamic programming to grid-based problems."

similar-problems:
  - "Unique Paths II"

follow-up-questions:
  - "How would the solution change if certain cells were blocked?"

solution-summary: "The solution uses a dynamic programming table to iteratively compute the number of unique paths to each cell."
*/
