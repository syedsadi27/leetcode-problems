class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, count = 0;
        int[] prefixSums = new int[nums.length + 1];
        prefixSums[0] = 1;
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                count += prefixSums[sum - goal];
            }
            prefixSums[sum]++;
        }
        return count;
    }
}



/*
problem-title: "Binary Subarrays With Sum"
problem-id: "966"
problem-link: "https://leetcode.com/problems/binary-subarrays-with-sum/"

problem-level: "Medium"
problem-category: "Arrays"
problem-area: ""
tags: ["Prefix Sum", "Hashmap"]

solving-strategy: "Prefix Sum with Hashmap"
algorithm-name: "Prefix Sum"

core-idea: "Use prefix sums and a hashmap to keep track of the number of ways to achieve a required sum."

observations:
  - "Subarray sums can be efficiently computed using prefix sums."
  - "A hashmap helps track how many times a particular prefix sum has appeared."

pattern-recognition:
  why-this-pattern: "Prefix sum is a common pattern for array subarray problems where specific sums are needed."

alternative-approaches:
  - "Two pointers sliding window."

why-not-alternatives: "Two pointers would not efficiently handle cases with many zeros."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "HashMap"

key-variables:
  left: ""
  right: ""
  currentSum: "sum"
  answer: "count"

invariants:
  - "Prefix sums accurately reflect subarray sums at every step."

edge-cases:
  - "All zeros."
  - "Sum exactly reaches and surpasses the goal."

dry-run-example: "Counting subarrays as sums grow and consulting prefix sums to find valid subarrays."

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: "Iterative subarray computation."
  to: "Optimized prefix sum with hashmap."

mistakes-to-avoid:
  - "Neglecting to initialize base condition for prefix sums."

implementation-notes:
  - "Ensure to handle sum boundary conditions."

confidence: "High"
difficulty-reason: "Use of hashmap increases overhead but simplifies for non-continuous array sums."

learning-outcome:
  - "Prefix sums are powerful for sum-based array problems."

similar-problems:
  - "Subarray Sum Equals K"

follow-up-questions:
  - "How does this solution adapt if elements are negative?"

solution-summary: "The solution efficiently calculates subarray sums using prefix sums combined with a hashmap to track occurrences."
*/
