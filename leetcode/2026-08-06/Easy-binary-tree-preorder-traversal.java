import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }
}



/*
problem-title: "Binary Tree Preorder Traversal"
problem-id: "144"
problem-link: "https://leetcode.com/problems/binary-tree-preorder-traversal/"

problem-level: "Easy"
problem-category: "Tree Traversal"
problem-area: "Binary Tree"
tags: ["Tree", "Stack", "Depth-First Search"]

solving-strategy: "Iterative approach using stack for DFS."
algorithm-name: "Depth-First Search"

core-idea: "Use a stack to perform preorder traversal (Node, Left, Right) iteratively."

observations:
  - "Preorder traversal visits node before its children."
  - "Stack helps manage the order of visiting nodes in DFS manner."

pattern-recognition:
  why-this-pattern: "Iterative DFS using a stack mimics the call stack of recursion efficiently."

alternative-approaches:
  - "Recursive traversal technique."

why-not-alternatives: "The iterative method is typically preferred for avoiding stack overflow issues and is often more efficient in terms of stack frame usage."

window-details:
  window-type: "N/A"
  expand-condition: "N/A"
  shrink-condition: "N/A"
  answer-update-condition: "N/A"

data-structures:
  - "Stack"

key-variables:
  left: "N/A"
  right: "N/A"
  currentSum: "N/A"
  answer: "result"

invariants:
  - "The stack maintains nodes to be visited next ensuring preorder sequence."

elementary-cases:
  - "Tree is empty (null root)."
  - "Tree has only one node."

dry-run-example: "Given root = [1,null,2,3], stack helps visit nodes: 1 -> 2 -> 3."

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: "Recursive stack-based approach."
  to: "Iterative stack-based approach."

mistakes-to-avoid:
  - "Pushing left child before right into stack to maintain correct order."

implementation-notes:
  - "Ensure to check null before starting traversal to handle edge cases."

confidence: "High"
difficulty-reason: "Simple application of stack-based iterative DFS."

learning-outcome:
  - "Learnt iterative DFS using a stack to avoid recursion pitfalls."

similar-problems:
  - "Binary Tree Inorder Traversal"
  - "Binary Tree Postorder Traversal"

follow-up-questions:
  - "Can you perform the other tree traversals using iteration?"

solution-summary: "Implemented an iterative preorder traversal using DFS with a stack, ensuring correct node visiting order and efficiently handling tree navigation without recursion."
*/
