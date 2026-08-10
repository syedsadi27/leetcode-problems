class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else { // nums[mid] == nums[right]
                right--;
            }
        }
        return nums[left];
    }
}



/*
problem-title: "Find Minimum in Rotated Sorted Array II"
problem-id: "154"
problem-link: "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/"

problem-level: "Hard"
problem-category: "Arrays"
problem-area: "Binary Search"
tags: []

solving-strategy: "Binary Search with adjustment for duplicates"
algorithm-name: "Modified Binary Search"

core-idea: "Use binary search to find the minimum element in a rotated sorted array, considering duplicates by potentially reducing the right boundary."

observations:
  - "The array can contain duplicates, impacting the binary search strategy."
  - "Comparing middle and right elements helps decide the direction."

pattern-recognition:
  why-this-pattern: "Binary search is efficient for sorted arrays, even when rotated, and adjustments handle duplicates."

alternative-approaches:
  - "Linear search can also find the minimum but isn't optimal in terms of time complexity."

why-not-alternatives: "Linear search has a worse time complexity, making it less suitable for larger arrays."

window-details:
  window-type: "Binary Search"
  expand-condition: "left = mid + 1 if nums[mid] > nums[right]"
  shrink-condition: "right = mid if nums[mid] < nums[right] or right-- if nums[mid] == nums[right]"
  answer-update-condition: "Minimum found at nums[left] when loop terminates"

data-structures:
  - "Array"

key-variables:
  left: "start of search range"
  right: "end of search range"
  currentSum: ""
  answer: "minimum element found"

invariants:
  - "Left boundary always points to a potential minimum."

edge-cases:
  - "Array has all identical numbers."
  - "Array is not rotated."

dry-run-example: "Given [2,2,2,0,1], start with left=0, right=4, iterate until left=3, right=3, find minimum at index."

complexity:
  time: "O(n) in worst case due to duplicates"
  space: "O(1)"

optimization:
  from: "Linear scan"
  to: "Binary search with duplicate handling"

mistakes-to-avoid:
  - "Not reducing the search space properly when duplicates are present."

implementation-notes:
  - "Adjust the `right` boundary for duplicates without compromising the search."

confidence: "High"
difficulty-reason: "Handling duplicates in a binary search setting complicates the implementation."

learning-outcome:
  - "Can devise binary search solutions that handle rotations and duplicates."

similar-problems:
  - "Find Minimum in Rotated Sorted Array"

follow-up-questions:
  - "How does the presence of duplicates affect the time complexity of binary search?"

solution-summary: "The solution adapts binary search for rotated arrays with duplicates by cautiously adjusting boundaries."
*/
