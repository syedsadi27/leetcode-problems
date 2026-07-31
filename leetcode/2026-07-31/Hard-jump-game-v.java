class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        int maxJumps = 0;
        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, dp, i, d));
        }

        return maxJumps;
    }

    private int dfs(int[] arr, int[] dp, int i, int d) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int max = 1; // At least the current index is visitable
        // Jump to the right
        for (int x = 1; x <= d && i + x < arr.length && arr[i] > arr[i + x]; x++) {
            max = Math.max(max, 1 + dfs(arr, dp, i + x, d));
        }

        // Jump to the left
        for (int x = 1; x <= d && i - x >= 0 && arr[i] > arr[i - x]; x++) {
            max = Math.max(max, 1 + dfs(arr, dp, i - x, d));
        }

        return dp[i] = max;
    }
}



/*
problem-title: "Jump Game V"
problem-id: "1466"
problem-link: "https://leetcode.com/problems/jump-game-v/"

problem-level: "Hard"
problem-category: "Dynamic Programming"
problem-area: "Arrays"
tags: ["Dynamic Programming", "DFS"]

solving-strategy: "Recursive DFS with memoization"
algorithm-name: "DFS + Memoization"

core-idea: "Use DFS with memoization to explore all possible max jumps from each index, caching results to avoid re-computation."

observations:
  - "Can jump right or left up to distance 'd'."
  - "Need to ensure jumps are made only to smaller elements."

pattern-recognition:
  why-this-pattern: "Dynamic programming with DFS is suitable due to overlapping subproblems and optimal substructure."

alternative-approaches:
  - "Iterative DP approach using sorting by heights."

why-not-alternatives: "DFS with memoization is more intuitive for exploring possible jumps."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Array for memoization"

key-variables:
  left: "x"
  right: "d"
  currentSum: ""
  answer: "max"

invariants:
  - "Each position is visited at most once in recursive computation."

edge-cases:
  - "Array of equal elements where no jumps are possible."
  - "Single element array."

dry-run-example: "For arr = [6,4,14,6,8,13,9,7,10,6,12] and d = 2, the solution identifies the maximum accessible positions from each point via memoized DFS."

complexity:
  time: "O(n * d)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not considering memoization leading to redundant subproblem solving."

implementation-notes:
  - "Initialize all dp values to -1 to indicate unvisited."

confidence: "High"
difficulty-reason: "Requires understanding recursive dfs with state caching in complex rules."

learning-outcome:
  - "How to apply DFS with memoization in dynamic programming problems involving arrays."

similar-problems:
  - "Jump Game"

follow-up-questions:
  - "Can this be optimized further with iterative dynamic programming?"

solution-summary: "The solution uses DFS with memoization to compute the longest path from each starting point by exploring jump possibilities constrained by the rules specified."
*/
