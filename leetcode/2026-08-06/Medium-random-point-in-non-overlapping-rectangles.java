import java.util.*;

class Solution {
    private int[][] rects;
    private int[] prefixSums;
    private Random random;
    private int totalPoints;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        int n = rects.length;
        this.prefixSums = new int[n];
        for (int i = 0; i < n; i++) {
            int[] rect = rects[i];
            int count = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalPoints += count;
            prefixSums[i] = totalPoints;
        }
    }

    public int[] pick() {
        int target = random.nextInt(totalPoints);
        int rectIndex = findRectIndex(target);

        // Pick a point within the chosen rectangle
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }

    private int findRectIndex(int target) {
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (prefixSums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}



/*
problem-title: "Random Point in Non-overlapping Rectangles"
problem-id: "914"
problem-link: "https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/"

problem-level: "Medium"
problem-category: "Algorithms"
problem-area: "Randomization"
tags: ["Random", "Prefix Sum", "Geometry"]

solving-strategy: "Prefix Sum and Binary Search"
algorithm-name: "Prefix Sum Array"

core-idea: "Use a prefix sum array to precompute the number of points in each rectangle, allowing weighted random selection."

observations:
  - "Each rectangle covers an integer grid of points."
  - "The number of points is the area of the rectangle."

pattern-recognition:
  why-this-pattern: "Weighted random selection to account for different rectangle areas."

alternative-approaches:
  - "Sampling from each rectangle uniformly, then combining."

why-not-alternatives: "Inefficient as it doesn't account for rectangle size in sampling effectively."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Prefix Sum Array"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Target index must map correctly onto a rectangle."

edge-cases:
  - "Single rectangle"
  - "Rectangles with minimum size"

dry-run-example: "Choosing a target point in the prefix sum allows identifying the correct rectangle."

complexity:
  time: "O(log N) per pick operation"
  space: "O(N)"

optimization:
  from: "Iterative checking of areas"
  to: "Binary search on prefix sums"

mistakes-to-avoid:
  - "Incorrect mapping from target to rectangle."

implementation-notes:
  - "Efficiently precompute point counts."

confidence: "High"
difficulty-reason: "Combination of geometry and random weighted selection."

learning-outcome:
  - "Using prefix sums for weighted random sampling."

similar-problems:
  - "528. Random Pick with Weight"

follow-up-questions:
  - "Can this be extended to higher dimensions?"

solution-summary: "This solution uses a prefix sum approach where each rectangle's total points are calculated and used in a weighted selection strategy, employing binary search for efficient querying."
*/
