class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // Position where target can be inserted
    }
}



/*
problem-title: "Search Insert Position"
problem-id: "35"
problem-link: "https://leetcode.com/problems/search-insert-position/"

problem-level: "Easy"
problem-category: "Binary Search"
problem-area: "Algorithms"
tags: ["Binary Search", "Array"]

solving-strategy: "Binary Search"
algorithm-name: "Binary Search"

core-idea: "Use binary search to efficiently find the target or the insert position."

observations:
  - "The array is sorted, allowing for binary search."
  - "The problem guarantees distinct integers, simplifying conditions."

pattern-recognition:
  why-this-pattern: "Binary search is ideal for sorted arrays to achieve O(log n) time complexity."

alternative-approaches:
  - "Linear search which would be O(n), not optimal."

why-not-alternatives: "Binary search is more efficient than linear search for this problem."

window-details:
  window-type: "Fixed"
  expand-condition: "mid < target, move right"
  shrink-condition: "mid > target, move left"
  answer-update-condition: "When target is found or loop exits"

data-structures:
  - "Array"

key-variables:
  left: "Start of current search window"
  right: "End of current search window"
  currentSum: ""
  answer: "The index where the target should be inserted"

invariants:
  - "Array is sorted"

edge-cases:
  - "Target is less than all elements."
  - "Target is greater than all elements."

dry-run-example: "nums = [1,3,5,6], target = 5; mid = 2 and target found at index 2."

complexity:
  time: "O(log n)"
  space: "O(1)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Missing increment/decrement of pointers."

implementation-notes:
  - "Use mid = left + (right - left) / 2 to avoid overflow."

confidence: "High"
difficulty-reason: "Simple binary search implementation due to sorted input and distinct elements."

learning-outcome:
  - "Understanding and implementing binary search."

similar-problems:
  - "Binary Search"

follow-up-questions:
  - "What if the array contains duplicates?"

solution-summary: "The solution uses binary search to locate or find the position to insert the target in O(log n) time."
*/
