class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int totalPoisonedTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalPoisonedTime += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return totalPoisonedTime + duration;
    }
}



/*
problem-title: "Teemo Attacking"
problem-id: "495"
problem-link: "https://leetcode.com/problems/teemo-attacking/"

problem-level: "Easy"
problem-category: "Array"
problem-area: ""
tags: []

solving-strategy: "Iterative Calculation"
algorithm-name: "Iterative Calculation"

core-idea: "Iterate over each attack and calculate the poisoned time, ensuring that overlapping poison intervals are handled by taking the minimum of the difference between consecutive attacks and the poison duration."

observations:
  - "The total poisoned duration should account for overlaps."
  - "The last attack always contributes the full duration."

pattern-recognition:
  why-this-pattern: "The problem requires consideration of sequential intervals and overlapping segments."

alternative-approaches:
  - "Use of a data structure to track intervals, which would be less efficient."

why-not-alternatives: "They complicate the solution without performance benefits given the problem constraints."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - ""

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "totalPoisonedTime"

invariants:
  - ""

edge-cases:
  - "No attacks, i.e., an empty array."
  - "Only one attack occurs."

dry-run-example: "For timeSeries [1, 2] and duration 2:\n1st attack contributes min(2, 1) = 1 second, 2nd attack contributes 2 seconds. Total = 3 seconds."

complexity:
  time: "O(n)", where n is the number of attacks.
  space: "O(1)"

optimization:
  from: "Tracking each poisoned time interval and merging."
  to: "Direct calculation while iterating."

mistakes-to-avoid:
  - "Assuming all attacks are non-overlapping."

implementation-notes:
  - "Ensure to handle the last attack separately or default to full duration."

confidence: "High"
difficulty-reason: "Straightforward calculation based on consecutive differences."

learning-outcome:
  - "Handling overlapping intervals efficiently."

similar-problems:
  - "Meeting Rooms II"

follow-up-questions:
  - "What if the duration changes over time?"

solution-summary: "Iteratively calculate poisoned durations by considering overlaps using min logic, ensuring all attacks are fully acknowledged."
*/
