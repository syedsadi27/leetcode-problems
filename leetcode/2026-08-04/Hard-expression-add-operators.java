import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();
        if (num == null || num.length() == 0) return results;
        backtrack(results, new StringBuilder(), num, target, 0, 0, 0);
        return results;
    }
    
    private void backtrack(List<String> results, StringBuilder path, String num, int target, int index, long currentVal, long lastVal) {
        if (index == num.length()) {
            if (currentVal == target) {
                results.add(path.toString());
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break; // Skip leading zero number
            long curr = Long.parseLong(num.substring(index, i + 1));
            int pathLen = path.length();
            
            if (index == 0) {
                backtrack(results, path.append(curr), num, target, i + 1, curr, curr);
                path.setLength(pathLen);
            } else {
                backtrack(results, path.append('+').append(curr), num, target, i + 1, currentVal + curr, curr);
                path.setLength(pathLen);

                backtrack(results, path.append('-').append(curr), num, target, i + 1, currentVal - curr, -curr);
                path.setLength(pathLen);

                backtrack(results, path.append('*').append(curr), num, target, i + 1, currentVal - lastVal + lastVal * curr, lastVal * curr);
                path.setLength(pathLen);
            }
        }
    }
}



/*
problem-title: "Expression Add Operators"
problem-id: "282"
problem-link: "https://leetcode.com/problems/expression-add-operators/"

problem-level: "Hard"
problem-category: "Backtracking"
problem-area: "Algorithms"
tags: []

solving-strategy: "Backtracking with expression construction"
algorithm-name: "Backtracking"

core-idea: "Use backtracking to insert operators between digits and evaluate the expression recursively."

observations:
  - "Leading zeros need to be skipped."
  - "Keep track of the current expression value and the last operand to handle the multiplication operator."

pattern-recognition:
  why-this-pattern: "The problem requires exploring all combinations recursively and evaluating expressions, which is well-suited for backtracking."

alternative-approaches:
  - "Dynamic programming, but it would complicate handling of the operators."

why-not-alternatives: "Backtracking allows a clean and exhaustive exploration of possibilities with pruning."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "StringBuilder for path construction."

key-variables:
  left: "index"
  right: "i"
  currentSum: "currentVal"
  answer: "results"

invariants:
  - "Each possible expression from start to end index is evaluated."

edge-cases:
  - "num length of 1."
  - "Target is 0 with multiple possible expressions resulting in 0."

dry-run-example: ""

complexity:
  time: "O(N * 4^N), where N is the length of the num string."
  space: "O(N), for the recursion stack."

optimization:
  from: "Backtracking without pruning."
  to: "Backtracking with pruning by handling leading zeros."

mistakes-to-avoid:
  - "Including expressions with leading zeros."

implementation-notes:
  - "Use StringBuilder to efficiently manage expression strings."

confidence: "High"
difficulty-reason: "Complex handling of operators precedence and recursion."

learning-outcome:
  - "Use backtracking for constructing all possible expressions."

similar-problems:
  - "Different ways to add parentheses"

follow-up-questions:
  - "What if the input string contains non-digit characters?"

solution-summary: "A backtracking approach systematically inserts operators and evaluates expressions, handling edge cases like leading zeros."
*/
