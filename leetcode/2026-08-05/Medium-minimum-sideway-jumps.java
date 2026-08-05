class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = {1, 0, 1}; // Minimum jumps to reach each lane at the start
        
        for (int i = 1; i < n; i++) {
            if (obstacles[i] != 0) {
                dp[obstacles[i] - 1] = Integer.MAX_VALUE; // Unreachable if there's an obstacle
            }
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    dp[j] = Math.min(dp[j], 
                                  Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}



/*
problem-title: "Minimum Sideway Jumps"
problem-id: "1952"
problem-link: "https://leetcode.com/problems/minimum-sideway-jumps/"

problem-level: "Medium"
problem-category: "Dynamic Programming"
problem-area: ""
tags: ["Dynamic Programming", "Greedy"]

solving-strategy: "Use dynamic programming to keep track of minimum jumps needed on each lane."
algorithm-name: "Dynamic Programming"

core-idea: "Maintain a dp array representing the minimum side jumps required to reach each lane at any point. Update it iteratively considering current obstacles."

observations:
  - "A frog starts at the second lane with an assumption that it needs minimum jumps initially."
  - "An obstacle makes a lane inaccessible, represented by setting the minimum jumps to infinity."

pattern-recognition:
  why-this-pattern: "We need to make decisions at each point considering obstacles and optimize for the minimum side jumps, which suits dynamic programming."

alternative-approaches:
  - "Use a BFS for level-order traversal to count jumps."

why-not-alternatives: "BFS would be less efficient due to higher time complexity in this context."

window-details:
  window-type: "Image each point as a window where decisions are reconsidered."
  expand-condition: "Consider adjacent lanes at the same point."
  shrink-condition: "Update only when an obstacle blocks the path."
  answer-update-condition: "Calculate minimum jumps considering potential alternatives."

data-structures:
  - "Array for dynamic programming state."

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "Minimum of all dp values at the last point."

invariants:
  - "Lane with an obstacle has unreachable state (infinity)."

edge-cases:
  - "Consecutive obstacles in different lanes at adjacent points."
  - "Obstacle only at the farthest point."

dry-run-example: "For obstacles = [0,1,2,3,0], calculation at each point demonstrates accurate dp updates."

complexity:
  time: "O(n)"
  space: "O(1), using only constant space for dp."

optimization:
  from: "Three-dimensional array or additional iterations to handle constraints."
  to: "Single array with constant updates."

mistakes-to-avoid:
  - "Not considering all three lanes simultaneously at a point."

implementation-notes:
  - "Ensure to mark obstacle lane with an extremely large value to prevent jumps."

confidence: "High"
difficulty-reason: "Clearly defined steps can be reasoned through dynamic programming based on obstacle presence."

learning-outcome:
  - "How to apply dynamic programming to path problems with constraints."

similar-problems:
  - "Frog Jump"
  - "Jump Game"

follow-up-questions:
  - "How would the approach change if there were more than three lanes?"

solution-summary: "Use a dynamic programming approach to track and minimize the side jumps needed while considering obstacle constraints at each point."
*/
