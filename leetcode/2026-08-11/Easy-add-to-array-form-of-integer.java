import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            result.add(k % 10);
            k /= 10;
            i--;
        }

        Collections.reverse(result);
        return result;
    }
}



/*
problem-title: "Add to Array-Form of Integer"
problem-id: "989"
problem-link: "https://leetcode.com/problems/add-to-array-form-of-integer/"

problem-level: "Easy"
problem-category: "Array"
problem-area: "Mathematics"
tags: []

solving-strategy: "Reverse traversal with carry management"
algorithm-name: "Reverse traversal"

core-idea: "Iterate from the end of the num array and efficiently handle the addition of num and k by managing the carry."

observations:
  - "Digits can be processed from least significant to most significant efficiently."
  - "Direct addition simplifies using integer division and modulo for digit management."

pattern-recognition:
  why-this-pattern: "This pattern is efficient for situations where numbers are too large to handle in a standard integer format."

alternative-approaches:
  - "Convert the entire number to a single integer, add k, then split it back into digits."

why-not-alternatives: "Direct simulation avoids overflow and retains precision, improving handling of constraints."

window-details:
  window-type: "N/A"
  expand-condition: "N/A"
  shrink-condition: "N/A"
  answer-update-condition: "N/A"

data-structures:
  - "ArrayList for dynamically adding result digits."

key-variables:
  left: ""
  right: "i, index within num array"
  currentSum: "sum of current digit and carry (using k)"
  answer: "result accumulates added digits"

invariants:
  - "Carry is always managed correctly at each digit addition."

edge-cases:
  - "num is a single digit."
  - "k is greater than any single-digit number."

dry-run-example: "For num = [1, 2, 0, 0] and k = 34, starting from the last digit we get [4, 3, 2, 1] after handling each addition step-by-step."

complexity:
  time: "O(max(n, log k))"
  space: "O(max(n, log k))"

optimization:
  from: "Iterating from start and using division"
  to: "Reverse traversal with real-time carry adjustment"

mistakes-to-avoid:
  - "Forgetting to reverse the result list at the end."

implementation-notes:
  - "Reversing the list ensures that digits are in the correct order since they are added from least significant to the most significant."

confidence: "High"
difficulty-reason: "Manageable size of input and simple arithmetic operations"

learning-outcome:
  - "Efficient handling of large numbers represented as arrays of digits."

similar-problems:
  - "Plus One"

follow-up-questions:
  - "How would you handle floating point numbers?"

solution-summary: "The solution simulates addition by traversing from least to most significant digit, allowing for arbitrary large numbers without overflow."
*/
