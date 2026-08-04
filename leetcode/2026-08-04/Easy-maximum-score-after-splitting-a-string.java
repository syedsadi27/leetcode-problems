class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }
        return maxScore;
    }
}



/*
problem-title: "Maximum Score After Splitting a String"
problem-id: "1537"
problem-link: "https://leetcode.com/problems/maximum-score-after-splitting-a-string/"

problem-level: "Easy"
problem-category: "String Manipulation"
problem-area: ""
tags: []

solving-strategy: "Iterative traversal"
algorithm-name: ""

core-idea: "Calculate the number of 1s in the whole string first. As you iterate through the string, count zeros for the left part and subtract 1s for the right part."

observations:
  - "To maximize the score, count zeros on the left and ones on the right."
  - "Only consider splits up to the second-to-last character to ensure two non-empty substrings."

pattern-recognition:
  why-this-pattern: "The maximum score is derived from an ongoing recalculation of two counters: left zeros and right ones."

alternative-approaches:
  - "Calculate splits in a brute force manner for each potential split and tally counts separately."

why-not-alternatives: "The alternative is less efficient and redundant as it would involve recalculating counts unnecessarily."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - ""

key-variables:
  left: "leftZeros"
  right: "rightOnes"
  currentSum: "leftZeros + rightOnes"
  answer: "maxScore"

invariants:
  - "At each step, leftZeros and rightOnes reflect the maximum score for splits extending up to the current index."

edge-cases:
  - "String starts with multiple 1s."
  - "String ends with multiple 0s."

dry-run-example: "For input '011101', initial ones: 4, split at indices and update left-zeros and right-ones for maximum score."

complexity:
  time: "O(n)"
  space: "O(1)"

optimization:
  from: "Brute force recalculation of zeros and ones for each split."
  to: "Single pass with counters for zeros and ones."

mistakes-to-avoid:
  - "Forgetting to restrict split to non-final position."

implementation-notes:
  - "Ensure correct initialization of counters and iterate properly."

confidence: "High"
difficulty-reason: "Simple traversal and counting problem with straightforward logic."

learning-outcome:
  - "Understand handling of left and right counters to optimize string manipulation problems."

similar-problems:
  - ""

follow-up-questions:
  - "Can this be extended to strings containing other characters or patterns?"

solution-summary: "Iterate over the string to calculate the number of zeros in the left substring and ones in the right, updating maximum score during one linear pass."
*/
