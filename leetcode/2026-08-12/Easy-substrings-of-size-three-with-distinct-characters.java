class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }
}



/*
problem-title: "Substrings of Size Three with Distinct Characters"
problem-id: "1987"
problem-link: "https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/"

problem-level: "Easy"
problem-category: "Strings"
problem-area: ""
tags: []

solving-strategy: "Sliding Window"
algorithm-name: ""

core-idea: "Iterate through the string and check if each substring of length 3 contains distinct characters."

observations:
  - "A substring of exactly three characters is checked for distinctness."
  - "Counting non-overlapping good substrings incrementally."

pattern-recognition:
  why-this-pattern: "Using a sliding window of fixed size to evaluate each possible substring."

alternative-approaches:
  - "Use a Set to check distinctness, but it would add unnecessary complexity."

why-not-alternatives: "Direct character comparison is more straightforward and efficient for fixed-length substrings."

window-details:
  window-type: "Fixed"
  expand-condition: "Not used"
  shrink-condition: "Automatically progresses with a fixed loop increment."
  answer-update-condition: "Substring has distinct characters."

data-structures:
  - ""

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Each substring of 3 characters is evaluated independently."

edge-cases:
  - "The input string length is less than 3."
  - "The string contains repeated characters at multiple positions."

dry-run-example: "For s = 'aababcabc', check abc, bca, cab, etc., increment count for distinct substrings."

complexity:
  time: "O(n)"
  space: "O(1)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not correctly handling the string's length under 3."

implementation-notes:
  - "Directly iterate with a loop and use charAt for comparisons."

confidence: "High"
difficulty-reason: "Straightforward use of basic iteration and comparison."

learning-outcome:
  - "Effectively using basic string operations to solve small constraint problems."

similar-problems:
  - ""

follow-up-questions:
  - "What if the substring length could vary or sizes larger than 3 were allowed?"

solution-summary: "Iterate through the string with a loop, check each substring of length 3 for distinct characters, and count the valid ones."
*/
