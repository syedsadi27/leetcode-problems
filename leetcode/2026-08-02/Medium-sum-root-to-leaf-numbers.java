/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;
        // If it is a leaf, return currentSum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        // Sum of left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}



/*
problem-title: "Sum Root to Leaf Numbers"
problem-id: "129"
problem-link: "https://leetcode.com/problems/sum-root-to-leaf-numbers/"

problem-level: "Medium"
problem-category: "Trees"
problem-area: "Algorithm"
tags: ["Tree", "Depth-first Search", "Binary Tree"]

solving-strategy: "Depth-first Search"
algorithm-name: "Recursive DFS"

core-idea: "Use DFS to calculate the sum for each root-to-leaf path by accumulating the current number and adding it when a leaf is reached."

observations:
  - "Each path in the tree can be viewed as a number by appending node values."
  - "DFS allows us to explore each path from root to leaf efficiently."

pattern-recognition:
  why-this-pattern: "DFS is ideal for traversing all possible paths from root to leaf in a tree structure."

alternative-approaches:
  - "Iterative DFS using a stack."

why-not-alternatives: "The recursive approach is cleaner and simpler for this problem size and constraints."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "TreeNode"

key-variables:
  left: "node.left"
  right: "node.right"
  currentSum: "Accumulates the current path's sum as a number."
  answer: "Result of the total sum of root-to-leaf numbers."

invariants:
  - "Node values are 0-9, so calculations stay within 32-bit integers."

edge-cases:
  - "Tree with only one node."
  - "Tree with a single path (left or right skewed)."

dry-run-example: "Traverse tree [4,9,0,5,1]: Path sums 495, 491, 40 give total 1026."

complexity:
  time: "O(n)"
  space: "O(h)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Mixing multiplication and addition orders for current number calculation."

implementation-notes:
  - "Pass accumulated sum down to leaf nodes in recursion."

confidence: "High"
difficulty-reason: "Understanding path accumulation correctly with digit manipulation."

learning-outcome:
  - "How to accumulate values through recursive traversal in trees."

similar-problems:
  - "Path Sum"

follow-up-questions:
  - "How would the approach change for large trees or larger node values?"

solution-summary: "Utilize DFS to traverse each tree path, accumulate root-to-leaf numbers, and sum them for the final result."
*/
