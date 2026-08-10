import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to store the index of each value from arr2
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            orderMap.put(arr2[i], i);
        }
        
        // Sort arr1 using a custom comparator
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (orderMap.containsKey(x) && orderMap.containsKey(y)) {
                    return Integer.compare(orderMap.get(x), orderMap.get(y));
                } else if (orderMap.containsKey(x)) {
                    return -1;
                } else if (orderMap.containsKey(y)) {
                    return 1;
                } else {
                    return Integer.compare(x, y);
                }
            }
        });

        // Unbox Integer[] back to int[]
        return Arrays.stream(arr1Integer).mapToInt(Integer::intValue).toArray();
    }
}



/*
problem-title: "Relative Sort Array"
problem-id: "1122"
problem-link: "https://leetcode.com/problems/relative-sort-array/"

problem-level: "Easy"
problem-category: "Sorting"
problem-area: "Arrays"
tags: ["HashMap", "Custom Sorting"]

solving-strategy: "Custom Comparator"
algorithm-name: "Custom Sorting"

core-idea: "Use a hashmap to store the order index of each element in arr2 and sort arr1 using this order."

observations:
  - "arr2 elements are distinct and present in arr1."
  - "Elements not in arr2 should be sorted normally."

pattern-recognition:
  why-this-pattern: "Hashmap facilitates O(1) lookups for order while sorting helps handle unspecified order."

alternative-approaches:
  - "Count sort based method using a frequency array."

why-not-alternatives: "Custom comparator keeps code concise and leverages Java's built-in sorting."

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
  currentSum: ""
  answer: ""

invariants:
  - "Order in arr2 is preserved in arr1 after sorting."

edge-cases:
  - "All elements of arr1 are in arr2."
  - "No elements of arr1 are in arr2."

dry-run-example: ""

complexity:
  time: "O(n log n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Misplacing elements that do not appear in arr2."

implementation-notes:
  - "Use boxed types for custom sorting in Java."

confidence: "High"
difficulty-reason: "Straightforward sorting problem with a known ordering from arr2."

learning-outcome:
  - "Learned use of custom comparators for complex sorting logic."

similar-problems:
  - ""

follow-up-questions:
  - "How to handle cases where arr2 elements are not distinct?"

solution-summary: "Use hashmap to store arr2 indices and custom comparator to sort arr1 accordingly."
*/
