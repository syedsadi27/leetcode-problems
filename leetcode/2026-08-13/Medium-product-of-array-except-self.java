class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize the result array with 1 as the identity for multiplication.
        result[0] = 1;
        
        // Calculate the products of all elements to the left of each element.
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int rightProduct = 1;
        // Calculate the products of all elements to the right and multiply with the left products.
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
}



/*
problem-title: "Product of Array Except Self"
problem-id: "238"
problem-link: "https://leetcode.com/problems/product-of-array-except-self/"

problem-level: "Medium"
problem-category: "Arrays"
problem-area: "Algorithm"
tags: []

solving-strategy: "Iterative left and right products"
algorithm-name: "Prefix and suffix product"

core-idea: "Use two passes to compute prefix and suffix products without division."

observations:
  - "Using division is not allowed, necessitating a prefix/suffix approach."
  - "The output array can be used to store intermediate computations to remain O(1) space."

pattern-recognition:
  why-this-pattern: "The problem requires computing products avoiding self, suited for prefix/suffix scan pattern."

alternative-approaches:
  - "Using a division approach."

why-not-alternatives: "The division approach violates the problem constraints."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Array"

key-variables:
  left: "Stores the product accumulated from the left."
  right: "rightProduct accumulates product from the right."
  currentSum: ""
  answer: "Result array that stores final products without self."

invariants:
  - "result[i] always holds the product of elements prefixed before i."

edge-cases:
  - "Single zero in the input array."
  - "All elements equal."

dry-run-example: "For nums = [1,2,3,4], product of others = [24,12,8,6]."

complexity:
  time: "O(n)"
  space: "O(1)"

optimization:
  from: "Separate arrays for left and right products."
  to: "Single array, result, to store intermediate and final results."

mistakes-to-avoid:
  - "Forgetting to use identity multiplication (1) when initializing the result array."

implementation-notes:
  - "Use a single pass to compute left products, update result in-place, and right products in reverse."

confidence: "5"
difficulty-reason: "Balance of complexity and efficiency in avoiding division constraints."

learning-outcome:
  - "Understanding of prefix/suffix product patterns without using division."

similar-problems:
  - "Trapping Rain Water"

follow-up-questions:
  - "How would you handle if negative numbers were included?"

solution-summary: "Efficiently calculate the product of array elements except self without division by utilizing prefix and suffix multiplications."
*/
