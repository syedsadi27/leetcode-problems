class Solution {
  public int totalNQueens(int n) {
    return solve(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
  }

  private int solve(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
    if (row == n)
      return 1;
    int count = 0;
    for (int col = 0; col < n; col++) {
      int id1 = col - row + n; // index for main diagonal
      int id2 = col + row; // index for anti-diagonal
      if (!cols[col] && !d1[id1] && !d2[id2]) {
        cols[col] = true;
        d1[id1] = true;
        d2[id2] = true;
        count += solve(row + 1, n, cols, d1, d2);
        cols[col] = false;
        d1[id1] = false;
        d2[id2] = false;
      }
    }
    return count;
  }
}

/*
 * problem-title: "N-Queens II"
 * problem-link: "https://leetcode.com/problems/n-queens-ii/"
 * 
 * problem-level: "Hard"
 * problem-category: "Backtracking"
 * problem-area: "Algorithms"
 * tags:
 * - Backtracking
 * - Bit Manipulation
 * 
 * solving-strategy: "Backtracking"
 * algorithm-name: "Backtracking with Pruning"
 * 
 * core-idea:
 * "Use backtracking to try placing queens row by row and check constraints for column, main diagonal, and anti-diagonal."
 * 
 * observations:
 * - "A queen can attack horizontally, vertically, and diagonally."
 * - "We use three arrays to keep track of threats in columns and diagonals."
 * 
 * pattern-recognition:
 * why-this-pattern:
 * "The problem requires finding all configurations, making backtracking suitable."
 * 
 * alternative-approaches:
 * - "Use bit manipulation for optimization."
 * 
 * why-not-alternatives:
 * "Bit manipulation is more complex and less readable compared to array-based backtracking."
 * 
 * window-details:
 * window-type: ""
 * expand-condition: ""
 * shrink-condition: ""
 * answer-update-condition: ""
 * 
 * data-structures:
 * - "Array"
 * 
 * solution-summary:
 * "The solution efficiently counts all valid placements of n queens using backtracking with constraint checks for each potential placement."
 */
