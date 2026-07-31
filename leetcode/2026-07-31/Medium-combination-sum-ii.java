import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void backtrack(int[] candidates, int remain, int start, List<Integer> combination, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // skip duplicates
            }
            if (candidates[i] > remain) {
                break; // no need to continue if the current number is greater than the remaining sum
            }
            combination.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}



/*
problem-title: "Combination Sum II"
problem-id: "40"
problem-link: "https://leetcode.com/problems/combination-sum-ii/"

problem-level: "Medium"
problem-category: "Backtracking"
problem-area: "Algorithms"
tags: []

solving-strategy: "Backtracking with pruning"
algorithm-name: "Backtracking"

core-idea: "Use backtracking to explore all possible combinations that sum to the target while skipping duplicates."

observations:
  - "Sorting helps in easily skipping duplicates."
  - "Early stopping can happen when the current number exceeds the remaining target."

pattern-recognition:
  why-this-pattern: "Backtracking is suitable for exploring all combinations and pruning can be applied by skipping duplicates."

alternative-approaches:
  - "Dynamic programming"

why-not-alternatives: "Dynamic programming would be less efficient due to additional space requirements and complexity of handling duplicate constraints."

window-details:
  window-type: "Recursive backtracking"
  expand-condition: "Include a number in the combination."
  shrink-condition: "Backtrack by removing the last element from the combination."
  answer-update-condition: "When target is reduced to zero."

data-structures:
  - "List to store current combination"

key-variables:
  left: ""
  right: ""
  currentSum: "remain"
  answer: "results"

invariants:
  - "remain is always non-negative."

edge-cases:
  - "Empty input array"
  - "All numbers larger than target"

dry-run-example: "For candidates [10,1,2,7,6,1,5] and target 8, backtrack will eventually find [1,1,6],[1,2,5],[1,7],[2,6]."

complexity:
  time: "O(2^n) where n is the number of candidates."
  space: "O(n) for the recursion stack."

optimization:
  from: "Using brute-force to try all combinations."
  to: "Prune unnecessary branches using sorting and skipping duplicates."

mistakes-to-avoid:
  - "Forgetting to sort candidates resulting in improper skipping of duplicates."

implementation-notes:
  - "Ensure candidates are sorted to facilitate skipping duplicates intelligently."

confidence: "High"
difficulty-reason: "Requires understanding of backtracking and handling of duplicate elements efficiently."

learning-outcome:
  - "How to utilize backtracking with sorting and conditions to avoid duplicates."

similar-problems:
  - "Combination Sum"

follow-up-questions:
  - "What if the candidates array is extremely large?"

solution-summary: "The solution applies backtracking and pruning by sorting the array, managing state with current combination, and skipping duplicates efficiently."
*/
