class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0, currentDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (ch == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}



/*
problem-title: "Maximum Nesting Depth of the Parentheses"
problem-id: "1737"
problem-link: "https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/"

problem-level: "Easy"
problem-category: "String"
problem-area: "Parentheses"
tags: []

solving-strategy: "Iterative traversal"
algorithm-name: ""

core-idea: "Iterate through the string, using a counter to track the current depth of nested parentheses."

observations:
  - "Every '(' increases depth by 1."
  - "Every ')' decreases depth by 1."

pattern-recognition:
  why-this-pattern: "Need to track opening and closing brackets to determine maximum nesting."

alternative-approaches:
  - "Using a stack to track parenthesis depth."

why-not-alternatives: "A simple counter is more space efficient than using a stack."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: "Update maxDepth on encountering '('."

data-structures:
  - ""

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "maxDepth"

invariants:
  - "currentDepth cannot be negative."

edge-cases:
  - "String with no parentheses."
  - "Nested parentheses at several levels."

dry-run-example: "For s = '(1)+((2))+(((3)))', maxDepth should be 3."

complexity:
  time: "O(n)"
  space: "O(1)"

optimization:
  from: "Using a stack."
  to: "Using a simple counter."

mistakes-to-avoid:
  - "Incorrectly decreasing depth before updating maxDepth."

implementation-notes:
  - "Max depth is updated with every '('."

confidence: "High"
difficulty-reason: "Simple counting logic with linear scan of string."

learning-outcome:
  - "Understand how to determine the nesting level by counting open and close parentheses."

similar-problems:
  - ""

follow-up-questions:
  - "How to handle invalid parentheses strings?"

solution-summary: "The solution iterates over the characters in the string, using a counter to track the depth of open parentheses and updating the maximum depth when necessary."
*/
