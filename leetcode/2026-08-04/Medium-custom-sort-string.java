class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }

        return result.toString();
    }
}



/*
problem-title: "Custom Sort String"
problem-id: "807"
problem-link: "https://leetcode.com/problems/custom-sort-string/"

problem-level: "Medium"
problem-category: "Sorting"
problem-area: "Strings"
tags: []

solving-strategy: "Hash Counting"
algorithm-name: "String Counting"

core-idea: "Count occurrences of each character in 's' and arrange according to the custom order given by 'order'."

observations:
  - "'order' provides the unique sequence order."
  - "Extra characters in 's' can be appended freely."

pattern-recognition:
  why-this-pattern: "Use counting to track characters in 's', then build the result following the prescribed order."

alternative-approaches:
  - "Sorting 's' with a custom comparator based on 'order'."

why-not-alternatives: "Counting is more efficient for this character-set since it is O(n) with smaller auxiliary space."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Array (for counting)"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Characters in 's' are processed and counted correctly."

edge-cases:
  - "All characters in 's' are in 'order'."
  - "No characters in 's' are in 'order'."

dry-run-example: "For order = 'cba', s = 'abcd': count letters and build using 'cba' then leftovers."

complexity:
  time: "O(n + m) where n is the length of order and m is the length of s."
  space: "O(1), constant space for count array of size 26."

optimization:
  from: "Sorting based approach or complex data structure."
  to: "Simple counting and string building."

mistakes-to-avoid:
  - "Forgetting to append characters not in 'order' at the end."

implementation-notes:
  - "Use a fixed size array to count occurrences efficiently."

confidence: "High"
difficulty-reason: "Takes advantage of constraints and small character limits allowing efficient counting."

learning-outcome:
  - "Utilize character counting to efficiently solve string order problems."

similar-problems:
  - "Sort Characters By Frequency"

follow-up-questions:
  - "How would this change if 'order' could repeat characters?"

solution-summary: "Count characters in 's' and construct the result by placing them in the order specified, handling extras afterwards."
*/
