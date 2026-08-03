class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        
        // BFS for level-by-level removal
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValid(str)) {
                result.add(str);
                found = true;
            }
            if (found) continue;
            // Generate all possible states
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String t = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}



/*
problem-title: "Remove Invalid Parentheses"
problem-id: "301"
problem-link: "https://leetcode.com/problems/remove-invalid-parentheses/"

problem-level: "Hard"
problem-category: ""
problem-area: ""
tags: []

solving-strategy: "Breadth-First Search (BFS)"
algorithm-name: "BFS"

core-idea: "Use BFS to explore all possible states by removing parentheses level by level until valid strings are found."

observations:
  - "Brute force checking all combinations would be too slow. BFS finds the minimum removals level by level."
  - "A set is used to avoid processing the same string multiple times."

pattern-recognition:
  why-this-pattern: "BFS ensures we find the shortest paths first, which is crucial for finding minimum removals."

alternative-approaches:
  - "Depth-First Search (DFS) approach with backtracking"

why-not-alternatives: "BFS is more intuitive for level-by-level exploration and ensures shortest minimal removal."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Queue for BFS"
  - "Set for storing visited states"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "result, which holds valid strings"

invariants:
  - ""

edge-cases:
  - "Empty string input"
  - "String with no parentheses"

dry-run-example: ""

complexity:
  time: "O(2^n), where n is the number of parentheses"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Ensure to only remove parentheses, not letters."

implementation-notes:
  - "Use a boolean to stop further processing as soon as a valid set is found."

confidence: "High"
difficulty-reason: "Complexity lies in choosing the right search strategy and managing state exploration."

learning-outcome:
  - "Understand the application of BFS to find shortest edits."

similar-problems:
  - "Minimum Remove to Make Valid Parentheses"

follow-up-questions:
  - "How would you handle longer strings efficiently?"

solution-summary: "The solution uses BFS to remove invalid parentheses and find valid strings with minimal removals. It explores states level by level ensuring minimum edits."
*/
