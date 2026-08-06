class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;
        int lowerNum = 0;
        int currNum = 0;
        int higherNum = 0;
        while (n / factor != 0) {
            lowerNum = (int) (n - (n / factor) * factor);
            currNum = (int) ((n / factor) % 10);
            higherNum = (int) (n / (factor * 10));
            
            if (currNum == 0) {
                count += higherNum * factor;
            } else if (currNum == 1) {
                count += higherNum * factor + lowerNum + 1;
            } else {
                count += (higherNum + 1) * factor;
            }
            factor *= 10;
        }
        return count;
    }
}



/*
problem-title: "Number of Digit One"
problem-id: "233"
problem-link: "https://leetcode.com/problems/number-of-digit-one/"

problem-level: "Hard"
problem-category: "Mathematics"
problem-area: "Algorithm"
tags: ["Math", "Counting"]

solving-strategy: "Place Value Analysis"
algorithm-name: "Digit Place Counting"

core-idea: "Analyze each digit's contribution to the overall count of ones from 0 to n."

observations:
  - "At any digit place, the number of 1s contributed depends on higher and lower digits."
  - "The contribution pattern varies when the current digit is 0, 1, or greater than 1."

pattern-recognition:
  why-this-pattern: "The pattern is derived from the place value, considering how each digit can contribute to the overall count of 1s."

alternative-approaches:
  - "Brute force counting for each number up to n."

why-not-alternatives: "Inefficient for large n due to high time complexity."

window-details:
  window-type: "Digit-by-digit"
  expand-condition: "Multiply factor by 10 to move to the next digit."
  shrink-condition: "None"
  answer-update-condition: "Update count based on the current digit's position factor."

data-structures:
  - "None specifically needed; uses arithmetic operations."

key-variables:
  left: "higherNum"
  right: "lowerNum"
  currentSum: "currNum-derived count update"
  answer: "count"

invariants:
  - "The factor is always a power of 10 and increases each iteration."

edge-cases:
  - "n is zero."
  - "n is a very large number up to the constraint limit."

dry-run-example: "For n = 13, iterate factors for 1 and 10 to count contributions."

complexity:
  time: "O(log10(n))"
  space: "O(1)"

optimization:
  from: "Brute force iteration from 0 to n."
  to: "Mathematical digit analysis reducing unnecessary checks."

mistakes-to-avoid:
  - "Incorrect handling of digit contributions when moving across powers of 10."

implementation-notes:
  - "Ensure factor increment and value calculations don't overflow."

confidence: "High, due to stable mathematical approach."
difficulty-reason: "Requires understanding of place value handling across various digit ranges."

learning-outcome:
  - "Gained understanding of efficient digit-place analysis for counting problems."

similar-problems:
  - "Number of Digit Two"

follow-up-questions:
  - "How would the solution adapt for counting other digits consistently?"

solution-summary: "Counts digit one by analyzing how each digit place (units, tens, hundreds, etc.) contributes to the total count through mathematical analysis of place values."
*/
