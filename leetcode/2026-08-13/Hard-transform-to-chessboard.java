class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int rowMask = 0, colMask = 0;
        int rowSwap = 0, colSwap = 0;
        
        for (int i = 0; i < n; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        
        int rowAltMask = ((1 << n) - 1) ^ rowMask;
        int colAltMask = ((1 << n) - 1) ^ colMask;
        int rowCount = 0, colCount = 0;
        
        for (int i = 0; i < n; i++) {
            int rowNum = 0, colNum = 0;
            for (int j = 0; j < n; j++) {
                rowNum |= (board[i][j] << j);
                colNum |= (board[j][i] << j);
            }

            if (rowNum != rowMask && rowNum != rowAltMask) return -1;
            if (rowNum == rowMask) rowCount++;
            if (colNum != colMask && colNum != colAltMask) return -1;
            if (colNum == colMask) colCount++;
        }

        if (Math.abs(n - 2 * rowCount) > 1 || Math.abs(n - 2 * colCount) > 1) return -1;

        for (int i = 0; i < n; i++) {
            if (((board[0][i] == 0) ? rowMask : rowAltMask) != (((i % 2) == 0) ? rowMask : rowAltMask)) rowSwap++;
            if (((board[i][0] == 0) ? colMask : colAltMask) != (((i % 2) == 0) ? colMask : colAltMask)) colSwap++;
        }

        if (n % 2 == 1) {
            if (rowSwap % 2 == 1) rowSwap = n - rowSwap;
            if (colSwap % 2 == 1) colSwap = n - colSwap;
        } else {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        }

        return (rowSwap + colSwap) / 2;
    }
}



/*
problem-title: "Transform to Chessboard"
problem-id: "798"
problem-link: "https://leetcode.com/problems/transform-to-chessboard/"

problem-level: "Hard"
problem-category: "Mathematics"
problem-area: ""
tags: []

solving-strategy: "Bitmask and Parity Check"
algorithm-name: ""

core-idea: "This solution involves checking the bitmask representation of rows and columns for validity and calculating swaps required."

observations:
  - "There are exactly two possible valid patterns for any row or column."
  - "The counts of row/column patterns must not differ by more than one."

pattern-recognition:
  why-this-pattern: "A valid chessboard only has two alternating patterns for rows and columns."

alternative-approaches:
  - "Brute-force all possible combinations of swaps."

why-not-alternatives: "Brute-force approach can lead to an exponential number of operations, which is not feasible."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Bit manipulation"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "Number of swaps needed"

invariants:
  - "Row and column swaps are independent and must respect pattern."

edge-cases:
  - "Odd dimensions where parity influences calculation."
  - "Boards with small size where direct patterns are easier to analyze."

dry-run-example: ""

complexity:
  time: "O(n^2)"
  space: "O(1)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Misinterpreting the pattern definitions or counts."

implementation-notes:
  - "Use bit manipulation to easily manage row and column state."

confidence: "High"
difficulty-reason: "Requires careful pattern recognition and row/column analysis."

learning-outcome:
  - "Understanding bit manipulation for pattern matching."

similar-problems:
  - ""

follow-up-questions:
  - "How to identify similar parity-based problems?"

solution-summary: "The solution checks pattern validity using bitmasks and calculations of swaps needed to achieve a valid chessboard layout."
*/
