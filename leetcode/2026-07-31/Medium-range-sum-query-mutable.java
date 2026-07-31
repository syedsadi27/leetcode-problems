class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int index, int val) {
        while (index <= n) {
            tree[index] += val;
            index += index & -index;
        }
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        add(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */



/*
problem-title: "Range Sum Query - Mutable"
problem-id: "307"
problem-link: "https://leetcode.com/problems/range-sum-query-mutable/"

problem-level: "Medium"
problem-category: "Data Structure"
problem-area: "Algorithms"
tags: ["Binary Indexed Tree", "Segment Tree"]

solving-strategy: "Data Structure Application"
algorithm-name: "Binary Indexed Tree"

core-idea: "The solution uses a Binary Indexed Tree (BIT) or Fenwick Tree to efficiently perform point updates and prefix sum queries."

observations:
  - "Binary Indexed Tree efficiently supports both point updates and prefix sum queries."
  - "The range sum can be derived from prefix sums."

pattern-recognition:
  why-this-pattern: "BIT is well-suited for scenarios requiring frequent updates and prefix/range queries."

alternative-approaches:
  - "Segment Tree"

why-not-alternatives: "Segment Tree can be more complex to implement and space-consuming compared to BIT."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Binary Indexed Tree"

key-variables:
  left: "left"
  right: "right"
  currentSum: "sum"
  answer: "sumRange(left, right)"

invariants:
  - "Sum of elements up to any index can be retrieved in logarithmic time."

edge-cases:
  - "Single element arrays."
  - "Updates that do not change the value."

dry-run-example: "For nums = [1,3,5], initial sumRange(0,2) = 9, update(1,2) changes array to [1,2,5], sumRange(0,2) after update = 8."

complexity:
  time: "O(log n)"
  space: "O(n)"

optimization:
  from: "Brute force sum on range queries."
  to: "Using BIT for logarithmic query/update time."

mistakes-to-avoid:
  - "Improperly indexing the BIT when performing updates or queries."

implementation-notes:
  - "Ensure 1-based indexing for BIT."

confidence: "High"
difficulty-reason: "Understanding BIT operations."

learning-outcome:
  - "Application of Binary Indexed Tree for sum queries and updates."

similar-problems:
  - "303. Range Sum Query - Immutable"
  - "304. Range Sum Query 2D - Immutable"

follow-up-questions:
  - "How would the solution scale if the input size were larger?"

solution-summary: "The Binary Indexed Tree allows for efficient range sum queries and point updates in logarithmic time, making it suitable for this problem's requirements."
*/
