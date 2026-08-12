class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0;
            }
        }

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue; // Temporarily ignore candidate edge
            int pu = findParent(parent, u);
            if (pu == v) {
                if (cand1 == null) return edge;
                return cand1;
            }
            parent[v] = pu;
        }
        return cand2;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}



/*
problem-title: "Redundant Connection II"
problem-id: "685"
problem-link: "https://leetcode.com/problems/redundant-connection-ii/"

problem-level: "Hard"
problem-category: "Graph"
problem-area: "Algorithms"
tags: ["Union-Find", "Graph Theory"]

solving-strategy: "Union-Find and checking two in-degrees"
algorithm-name: "Union-Find"

core-idea: "Detect possible two parents, then apply Union-Find for cycle detection"

observations:
  - "A node with two parents cannot exist in a tree"
  - "Cycle detection is key for finding redundant connection"

pattern-recognition:
  why-this-pattern: "Union-Find helps in efficiently detecting cycles in disjoint set structures"

alternative-approaches:
  - "DFS to find cycles directly initially"

why-not-alternatives: "Union-Find offers better cycle detection efficiency over direct graph traversal methods with early pruning capabilities."

window-details:
  window-type: "N/A"
  expand-condition: "N/A"
  shrink-condition: "N/A"
  answer-update-condition: "N/A"

data-structures:
  - "Union-Find arrays"

key-variables:
  left: "N/A"
  right: "N/A"
  currentSum: "N/A"
  answer: "the edge causing cycle or pseudo root redundancy"

invariants:
  - "Each node must have at most one parent if the tree structure is maintained after removal"

edge-cases:
  - "Multiple nodes having same incoming connection"
  - "Cycle formation possible only after ignoring one of degree two nodes"

dry-run-example: "Run through example inputs first identifying nodes with dual parents, then appling Union-Find for cycle issues"

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: "Cycle detection through elaborate graph traversal"
  to: "Using Union-Find to manage disjoint sets and detect cycles"

mistakes-to-avoid:
  - "Not resetting structure for second traversal of edges"

implementation-notes:
  - "Ensure temporarily ignored edge for dual degree is correctly restored"

confidence: "Medium"
difficulty-reason: "Managing multiple solutions due to variable interpretations of requirements"

learning-outcome:
  - "Effectiveness of Union-Find in cycle resolution"

similar-problems:
  - "Redundant Connection"

follow-up-questions:
  - "How to handle more general cyclic graphs?"

solution-summary: "Handle dual parent scenarios carefully, apply Union-Find for detecting fundamental cycles."
*/
