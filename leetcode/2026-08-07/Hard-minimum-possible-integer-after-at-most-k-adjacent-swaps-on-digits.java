class Solution {
    public String minInteger(String num, int k) {
        char[] result = num.toCharArray();
        for (int i = 0; i < result.length; i++) {
            int minIndex = i;
            // Find the minimum from i to min(i + k, n)
            for (int j = i + 1; j < result.length && j <= i + k; j++) {
                if (result[j] < result[minIndex]) {
                    minIndex = j;
                }
            }
            // If the minIndex is not i, perform swaps to move it
            if (minIndex != i) {
                char minChar = result[minIndex];
                // Move the minChar to position i, swapping adjacent digits
                for (int j = minIndex; j > i; j--) {
                    result[j] = result[j - 1];
                }
                result[i] = minChar;
                k -= (minIndex - i);
                if (k <= 0) break;  // No more swaps available
            }
        }
        return new String(result);
    }
}



/*
problem-title: "Minimum Possible Integer After at Most K Adjacent Swaps On Digits"
problem-id: "1629"
problem-link: "https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/"

problem-level: "Hard"
problem-category: "Optimization"
problem-area: "Greedy"
tags: ["Greedy", "Sorting"]

solving-strategy: "Iterative Greedy Selection"
algorithm-name: "Greedy Approach"

core-idea: "Iteratively select the smallest digit within the allowed range determined by remaining swaps (k). Move it to the current position by adjacent swaps."

observations:
  - "Swapping with minimal larger numbers leads to lexicographically smaller numbers."
  - "Selection of the smallest number within a bounded range helps achieve minimum sequence."

pattern-recognition:
  why-this-pattern: "Finding the smallest lexicographical order by moving the smallest possible candidate in the feasible range."

alternative-approaches:
  - "Segment trees for efficient range minimum queries."

why-not-alternatives: "Segment trees add complexity and may not be necessary due to simple constraints."

window-details:
  window-type: "Variable sliding window"
  expand-condition: "Expands as it looks for minimum within k steps."
  shrink-condition: "Does not explicitly shrink but iterates over next positions."
  answer-update-condition: "Updates after swapping to move the minimum value forward."

data-structures:
  - "Array"

key-variables:
  left: "i"
  right: "i + k"
  currentSum: "N/A"
  answer: "result"

invariants:
  - "The number of swaps should not exceed k"

edge-cases:
  - "No swaps (k = 0)."
  - "All swaps available but the order is already minimal."

dry-run-example: "For num = '4321', k = 4, iteratively selects and swaps to get '1342'."

complexity:
  time: "O(n * min(k, n))"
  space: "O(n)"

optimization:
  from: "Exhaustive search"
  to: "Greedy selection minimizes work by focusing on local optimum selections."

mistakes-to-avoid:
  - "Attempting swaps exceeding available k, leading to over-complexity."

implementation-notes:
  - "Ensure the swap limit is respected to avoid unnecessary computation."

confidence: "High"
difficulty-reason: "Requires efficient handling of large constraints with limited operations."

learning-outcome:
  - "Greedy strategies can efficiently solve optimization problems by locally choosing the best option."

similar-problems:
  - "Minimum Number of Swaps to Make the String Balanced"

follow-up-questions:
  - "How would the approach change with varying values of k, especially larger values?"

solution-summary: "The solution employs a greedy strategy to find and move the minimal adjacent digits while respecting the swap limit k."
*/
