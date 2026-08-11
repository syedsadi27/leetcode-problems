class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length, n = targetGrid[0].length;
        int[] minRow = new int[61], maxRow = new int[61], minCol = new int[61], maxCol = new int[61];
        
        for (int i = 0; i <= 60; i++) {
            minRow[i] = minCol[i] = Integer.MAX_VALUE;
            maxRow[i] = maxCol[i] = -1;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                minRow[color] = Math.min(minRow[color], i);
                maxRow[color] = Math.max(maxRow[color], i);
                minCol[color] = Math.min(minCol[color], j);
                maxCol[color] = Math.max(maxCol[color], j);
            }
        }

        boolean[] done = new boolean[61];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int color = 1; color <= 60; color++) {
                if (done[color]) continue;
                boolean canPrint = true;
                for (int i = minRow[color]; i <= maxRow[color] && canPrint; i++) {
                    for (int j = minCol[color]; j <= maxCol[color] && canPrint; j++) {
                        if (targetGrid[i][j] != 0 && targetGrid[i][j] != color) {
                            canPrint = false;
                        }
                    }
                }
                if (canPrint) {
                    changed = true;
                    done[color] = true;
                    for (int i = minRow[color]; i <= maxRow[color]; i++) {
                        for (int j = minCol[color]; j <= maxCol[color]; j++) {
                            targetGrid[i][j] = 0;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (targetGrid[i][j] != 0) return false;
            }
        }

        return true;
    }
}



/*
problem-title: "Strange Printer II"
problem-id: "1696"
problem-link: "https://leetcode.com/problems/strange-printer-ii/"

problem-level: "Hard"
problem-category: "Graph"
problem-area: "DFS/BFS"
tags: []

solving-strategy: "Simulate the painting process by checking if each color can be completely printed as a rectangle in the current grid."
algorithm-name: "Greedy with Dependency Tracking"

core-idea: "Attempt to paint each color rectangle if there are no dependencies blocking it, marking as done once painted."

observations:
  - "Each color is used once to paint its rectangular area."
  - "Must respect topological order of painting due to overlap constraints."

pattern-recognition:
  why-this-pattern: "Identify independent rectangles to simulate topological painting order."

alternative-approaches:
  - "Use topological sorting to identify a correct paint order."

why-not-alternatives: "Complexity in detecting cycle order without predetermined dependency structure."

window-details:
  window-type: "Rectangular color area."
  expand-condition: "Find min/max bounds for each color."
  shrink-condition: "Paint an entire rectangle of color, clearing grid area."
  answer-update-condition: "If all colors could be printed/erased cleanly."

data-structures:
  - "2D Arrays"
  - "Boolean Arrays"

key-variables:
  left: "minCol[color]"
  right: "maxCol[color]"
  currentSum: "Used for tracking grid coloring state."
  answer: "done[] array to mark completion of colors."

invariants:
  - "Once a color is cleared, its area remains empty (0) until painting is successful."

edge-cases:
  - "Single row/column grids."
  - "Grid with already sorted color blocks."

dry-run-example: "Consider a sample grid to ensure rectangles for all colors can complete without remaining dependencies."

complexity:
  time: "O(m * n * 60)"
  space: "O(m * n)"

optimization:
  from: "Complex cycle-testing through recursive dependency checking."
  to: "Simplified greedy check for independent completion."

mistakes-to-avoid:
  - "Incorrectly assuming circular dependencies don't exist."

implementation-notes:
  - "Carefully track and update bounds for each color, removing only when no overlap prevents print."

confidence: "High due to controlled rectangular dependency detection."
difficulty-reason: "Grid coloring and dependency resolution under strict constraints."

learning-outcome:
  - "Deep insights into painting sequence and dependencies in grid environments."

similar-problems:
  - "Scheduling with dependency constraints"
  - "Grid traversal and covering"

follow-up-questions:
  - "How does complexity change with different painting rules?"

solution-summary: "Assume topological order and greedily erase the rectangles in that order verifying constraints, ensuring completion."
*/
