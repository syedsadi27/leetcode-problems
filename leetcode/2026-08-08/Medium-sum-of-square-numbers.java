class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }
}



/*
problem-title: "Sum of Square Numbers"
problem-id: "633"
problem-link: "https://leetcode.com/problems/sum-of-square-numbers/"

problem-level: "Medium"
problem-category: "Mathematics"
problem-area: ""
tags: ["Two Pointers", "Mathematics"]

solving-strategy: "Brute Force with Optimization"
algorithm-name: "Two Pointers"

core-idea: "Iterate over possible squares for 'a' and check if 'c - a^2' is a perfect square."

observations:
  - "The maximum possible value for 'a^2' can be 'c'."
  - "If 'b' is an integer, then 'a' and 'b' satisfying 'a^2 + b^2 = c' are found."

pattern-recognition:
  why-this-pattern: "Using two variables 'a' and 'b' to evaluate condition without redundant checks."

alternative-approaches:
  - "Use a hash set to store squares and check."

why-not-alternatives: "Hash set requires more space and doesn't provide better time performance."

window-details:
  window-type: "Two pointers with mathematical checks"
  expand-condition: "Iterate 'a' up and check for corresponding 'b'"
  shrink-condition: ""
  answer-update-condition: "If 'b' is an integer, return true."

data-structures:
  - ""

key-variables:
  left: "a"
  right: "b"
  currentSum: "a^2 + b^2"
  answer: "boolean indicating if such numbers were found"

invariants:
  - "0 <= a^2 <= c"

edge-cases:
  - "c = 0, where a = 0 and b = 0"
  - "c is a perfect square itself"

dry-run-example: "For c=5, a=1 gives b=2, where 1^2 + 2^2 = 5."

complexity:
  time: "O(sqrt(c))"
  space: "O(1)"

optimization:
  from: "Check all pairs (a, b)"
  to: "Check pairs only up to the square root of c"

mistakes-to-avoid:
  - "Ensure 'b' is an integer by casting to int after square root calculation."

implementation-notes:
  - "Iterate till 'a^2' exceeds 'c'. Check perfect-square condition for 'b'."

confidence: "High"
difficulty-reason: "Requires knowledge of perfect squares and iteration up to square root."

learning-outcome:
  - "Learn to reason with constraints and conditions for perfect squares."

similar-problems:
  - ""

follow-up-questions:
  - "How would you solve this if negative numbers were considered?"

solution-summary: "Iterate over potential values of 'a' and calculate 'b'. Check if both form a valid solution."
*/
