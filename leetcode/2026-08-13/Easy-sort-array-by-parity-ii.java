class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int oddIndex = 1;
        int evenIndex = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return result;
    }
}



/*
problem-title: "Sort Array By Parity II"
problem-id: "958"
problem-link: "https://leetcode.com/problems/sort-array-by-parity-ii/"

problem-level: "Easy"
problem-category: "Array"
problem-area: ""
tags: []

solving-strategy: ""
algorithm-name: "Index Tracking"

core-idea: "Separate even and odd positioning with two pointers to appropriately place elements."

observations:
  - "Even numbers should be placed at even indices."
  - "Odd numbers should be placed at odd indices."

pattern-recognition:
  why-this-pattern: "Using two pointers helps intake the order of even and odd positions efficiently."

alternative-approaches:
  - "Two-pass solution collecting odds and evens first, then placing them."

why-not-alternatives: "The two-pointer approach is more space efficient and intuitive for this problem."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Array"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "Result array"

invariants:
  - "Odd index to track placement of odd numbers."
  - "Even index to track placement of even numbers."

edge-cases:
  - "Minimal array size of 2."
  - "All elements already in place."

dry-run-example: "For nums = [4,2,5,7], start with 4 (even) -> index 0, then 2 (even) -> index 2, 5 (odd) -> index 1, 7 (odd) -> index 3."

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Misplacing even-odd number during iteration."

implementation-notes:
  - "Ensure indices always stay within bounds."

confidence: "High"
difficulty-reason: "Straightforward index manipulation problem."

learning-outcome:
  - "Learned the utility of pointer-based array manipulation."

similar-problems:
  - "Sort Array By Parity"

follow-up-questions:
  - "Can this be done in-place without extra space?"

solution-summary: "Use two pointers to separate even and odd indices, placing elements correctly in a new array."
*/
