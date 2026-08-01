import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, new int[4], matchsticks.length - 1, sum / 4);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == -1) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        int matchstick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchstick <= target) {
                sides[i] += matchstick;
                if (backtrack(matchsticks, sides, index - 1, target)) {
                    return true;
                }
                sides[i] -= matchstick;
            }
            if (sides[i] == 0) {
                break;
            }
        }
        return false;
    }
}



/*
problem-title: "Matchsticks to Square"
problem-id: "473"
problem-link: "https://leetcode.com/problems/matchsticks-to-square/"

problem-level: "Medium"
problem-category: "Backtracking"
problem-area: "Algorithm"
tags: ["Backtracking", "Array", "Sorting"]

solving-strategy: "Use backtracking to try all possible side combinations."
algorithm-name: "Backtracking"

core-idea: "Try to form all sides of equal length recursively, ensuring no side exceeds the target length."

observations:
  - "If the total sum of matchsticks is not divisible by 4, a square cannot be formed."
  - "Sorting helps to attempt larger values first, potentially reducing unnecessary calculations."

pattern-recognition:
  why-this-pattern: "Squares require all sides to be equal, necessitating exact matching of side sums."

alternative-approaches:
  - "Dynamic programming with memoization could also be considered to store intermediate results."

why-not-alternatives: "Backtracking is more straightforward given the constraint limits."

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
  currentSum: "sides array carries current sums of sticks forming sides."
  answer: ""

invariants:
  - "Sides' sums should never exceed the target value."

edge-cases:
  - "List too short to form a square."
  - "Total length not divisible by 4."

dry-run-example: "For matchsticks [1,1,2,2,2], target is 2. The function recursively tries forming sides of length 2."

complexity:
  time: "O(4^n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not properly checking base cases like insufficient numbers or invalid total length."

implementation-notes:
  - "Sort matchsticks to attempt larger ones first, improving backtracking efficiency."

confidence: "High"
difficulty-reason: "The problem involves careful management of recursive state and pruning conditions."

learning-outcome:
  - "How to apply backtracking for partitioning problems."

similar-problems:
  - "Partition to K Equal Sum Subsets"

follow-up-questions:
  - "What if we wanted to form a rectangle instead of a square?"

solution-summary: "Sort matchsticks and use backtracking to try forming sides incrementally, checking for possible completions recursively."
*/
