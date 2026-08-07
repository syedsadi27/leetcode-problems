class Solution {
    public int subsetXORSum(int[] nums) {
        return calculateXOR(nums, 0, 0);
    }
    
    private int calculateXOR(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR; // Base case: return the XOR for this subset
        }
        // Calculate the sum of XORs including and excluding the current element
        return calculateXOR(nums, index + 1, currentXOR ^ nums[index]) + calculateXOR(nums, index + 1, currentXOR);
    }
}



/*
problem-title: "Sum of All Subset XOR Totals"
problem-id: "1993"
problem-link: "https://leetcode.com/problems/sum-of-all-subset-xor-totals/"

problem-level: "Easy"
problem-category: "Recursion"
problem-area: "Bit Manipulation"
tags: ["Recursion", "Bit Manipulation"]

solving-strategy: "Recursively explore subsets by choosing or ignoring each element, and compute XOR totals."
algorithm-name: "Backtracking"

core-idea: "Use recursion to explore all possible subsets, computing the XOR total of each, and sum up the results."

observations:
  - "Each element can either be included or not in a subset."
  - "The XOR of elements is associative and commutative."

pattern-recognition:
  why-this-pattern: "Subset problems often require exploring all possible combinations, achievable by recursive backtracking."

alternative-approaches:
  - "Iterative solution using bit-masking to generate all subsets."

why-not-alternatives: "Recursive method is straightforward and easy to implement for this small input size."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - ""

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Index should not go out of bounds."

edge-cases:
  - "Empty input array."
  - "Array with one element."

dry-run-example: "For nums = [1,3], the function will recurse through subsets: [], [1], [3], and [1,3] with XOR totals 0, 1, 3, 2 respectively."

complexity:
  time: "O(2^n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not handling base case correctly in recursion."

implementation-notes:
  - "Ensure base case returns the currentXOR for single subset evaluation."

confidence: "High"
difficulty-reason: "Recursive exploration of subsets is a known technique for such problems."

learning-outcome:
  - "Practice recursive tree traversal and subset generation."

similar-problems:
  - "Subset Sum"

follow-up-questions:
  - "How would you handle the problem for larger input sizes?"

solution-summary: "By using recursion to explore all subsets and calculate their XOR totals, we sum these totals to achieve the final answer."
*/
