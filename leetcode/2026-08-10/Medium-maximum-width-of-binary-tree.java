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
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));  // Pair of node and index
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().getValue();  // Index of first node in this level
            int end = start;  // Track the last node's index
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue();
                end = index;  // Update the last node's index
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 1));
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}



/*
problem-title: "Maximum Width of Binary Tree"
problem-id: "662"
problem-link: "https://leetcode.com/problems/maximum-width-of-binary-tree/"

problem-level: "Medium"
problem-category: "Binary Tree"
problem-area: ""
tags: ["BFS", "Tree Traversal"]

solving-strategy: "Breadth-First Search with level tracking"
algorithm-name: "Breadth-First Search"

core-idea: "Use BFS to traverse the tree level by level, tracking node indices to determine width."

observations:
  - "Each node can be indexed like a complete binary tree."
  - "Using indices, the width of each level is defined by the difference between indices of the rightmost and leftmost nodes."

pattern-recognition:
  why-this-pattern: "BFS is suitable for level-wise traversal, which facilitates direct width computation."

alternative-approaches:
  - "Depth-First Search with similar index tracking."

why-not-alternatives: "BFS naturally handles level separation and simplifies index boundary tracking."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Queue"

key-variables:
  left: "Index of leftmost node in current level."
  right: "Index of rightmost node in current level."
  currentSum: ""
  answer: "Maximum width across all levels."

invariants:
  - "Each level's index range is tracked accurately."

edge-cases:
  - "Single node tree."
  - "Complete tree"

dry-run-example: "Use the example [1,3,2,5,null,null,9] and trace the queue and indices at each level."

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Incorrectly calculating width not accounting for potential gaps due to null nodes."

implementation-notes:
  - "Use a helper Pair class to track nodes with their respective indices in the queue."

confidence: "High"
difficulty-reason: "Level order traversal with extra bookkeeping for indices."

learning-outcome:
  - "How to manage indices in a tree level using BFS."

similar-problems:
  - "Binary Tree Level Order Traversal"
  - "Minimum Depth of Binary Tree"

follow-up-questions:
  - "Can this approach be extended to handle arbitrary binary tree structures in parallel streams?"

solution-summary: "The solution employs BFS to traverse the binary tree, keeping track of indices to compute the maximum width accurately."
*/
