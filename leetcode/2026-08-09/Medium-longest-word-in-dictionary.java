import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        
        for (String word : words) {
            boolean valid = true;
            for (int k = 1; k < word.length(); k++) {
                if (!wordSet.contains(word.substring(0, k))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return word;
            }
        }
        return "";
    }
}



/*
problem-title: "Longest Word in Dictionary"
problem-id: "720"
problem-link: "https://leetcode.com/problems/longest-word-in-dictionary/"

problem-level: "Medium"
problem-category: "String"
problem-area: "Strings and Data Structures"
tags: ["HashSet", "Sorting", "String Manipulation"]

solving-strategy: "Sort and Validate"
algorithm-name: "Sort and Check Prefixes"

core-idea: "Sort words by length and lexicographical order, then find the longest word whose prefixes are all valid words."

observations:
  - "Sorting helps prioritize longer words and resolve ties lexicographically."
  - "HashSet provides efficient prefix existence checks."

pattern-recognition:
  why-this-pattern: "Sorting and set operations efficiently handle validation of word construction."

alternative-approaches:
  - "Using a Trie data structure to store and validate prefixes."

why-not-alternatives: "A Trie would require additional implementation complexity without performance gain given constraints."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "HashSet"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "longest valid word found."

invariants:
  - ""

edge-cases:
  - "Empty input or no valid buildable word."
  - "Multiple words could be valid; choose smallest lexicographically."

dry-run-example: "For words ['w', 'wo', 'wor', 'worl', 'world'], 'world' is valid as each prefix exists in the set."

complexity:
  time: "O(n log n) for sorting and O(n * k^2) for validation, where n is the number of words and k is the average length of a word."
  space: "O(n) for storing words in HashSet."

optimization:
  from: "Brute force checking all prefixes."
  to: "Sort and check using HashSet."

mistakes-to-avoid:
  - "Not checking all prefixes of a word in the right order."
  - "Ignoring the lexicographical tie-breaking rule."

implementation-notes:
  - "Ensure the loop checks all prefixes starting from length 1."

confidence: "High"
difficulty-reason: "Sorting and set operations are common patterns; understanding prefix validation is key."

learning-outcome:
  - "Understanding efficiency of prefix checks using sets."

similar-problems:
  - "Longest String Chain"

follow-up-questions:
  - "How would the solution change if words could contain other characters?"

solution-summary: "The solution sorts the list to focus on the longest and lexicographically smallest words first, utilizing a set to efficiently check if all prefixes of the current word are present, ensuring it can be constructed step-by-step."
*/
