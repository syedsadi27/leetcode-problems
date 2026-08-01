import java.util.*;

class Solution {
    private static final int MAX = 1000000;
    private static final int LIMIT = 20000;
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }
        // Check if either source or target is trapped
        return isAccessible(blockedSet, source, target) && isAccessible(blockedSet, target, source);
    }
    
    private boolean isAccessible(Set<String> blockedSet, int[] start, int[] end) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            steps++;
            // If reached the other point or explored enough
            if (Arrays.equals(current, end) || steps > LIMIT) return true;
            
            for (int[] direction : DIRECTIONS) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                
                String coordinate = x + "," + y;
                if (x >= 0 && y >= 0 && x < MAX && y < MAX && !blockedSet.contains(coordinate) && !visited.contains(coordinate)) {
                    queue.offer(new int[]{x, y});
                    visited.add(coordinate);
                }
            }
        }
        return false;
    }
}



/*
problem-title: "Escape a Large Maze"
problem-id: "1106"
problem-link: "https://leetcode.com/problems/escape-a-large-maze/"

problem-level: "Hard"
problem-category: "Graph"
problem-area: "Algorithms"
tags: ["BFS", "HashSet"]

solving-strategy: "Use BFS to check if we can reach target and vice versa."
algorithm-name: "Bidirectional BFS"

core-idea: "Use bidirectional BFS from source and target within a limited boundary to determine connectivity, while avoiding blocked cells."

observations:
  - "The problem is bounded by blocked cells which can form an enclosing barrier."
  - "If there are no barriers or we can traverse beyond blocked bounds, reaching is possible."

pattern-recognition:
  why-this-pattern: "BFS allows systematic exploration of reachable nodes, suitable for shortest path in unweighted grid scenarios."

alternative-approaches:
  - "A* Search"

why-not-alternatives: "A* may be more computationally expensive here since the problem is about possibility, not optimal path."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "HashSet"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Steps that exceed limit imply freedom beyond blocked perimeter."

edge-cases:
  - "Source and target are surrounded by blocked cells."
  - "No blocked cells, ensuring direct path."

dry-run-example: "For blocked = [], source = [0,0], target = [999999,999999]:
   Direct BFS towards target would succeed as path is unobstructed."

complexity:
  time: "O(min(M^2, B^2)) where B is number of blocked cells and M is 10^6."
  space: "O(B)"

optimization:
  from: "Checking full boundaries."
  to: "Limiting BFS exploration based on possible enclosed regions."

mistakes-to-avoid:
  - "Assuming escape is guaranteed without checking barriers."

implementation-notes:
  - "Use serialization of coordinates for efficient look-up in blocked set."

confidence: "High"
difficulty-reason: "High complexity due to large grid and potential enclosure by blocks."

learning-outcome:
  - "Understand BFS application beyond simple shortest paths."

similar-problems:
  - "Network Delay Time"

follow-up-questions:
  - "How could real maze-like structures affect algorithm design?"

solution-summary: "The solution applies BFS to check mutual reachability within a restricted perimeter, effectively handling the constraints imposed by blocked cells."
*/
