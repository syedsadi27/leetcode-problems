class Solution {
    public int maximum69Number (int num) {
        // Convert the number to a character array
        char[] digits = Integer.toString(num).toCharArray();
        
        // Traverse the array
        for (int i = 0; i < digits.length; i++) {
            // Change the first '6' to '9'
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        
        // Convert the character array back to an integer
        return Integer.parseInt(new String(digits));
    }
}



/*
problem-title: "Maximum 69 Number"
problem-id: "1448"
problem-link: "https://leetcode.com/problems/maximum-69-number/"

problem-level: "Easy"
problem-category: "Mathematical & String"
problem-area: "Number Conversion"
tags: ["String Manipulation"]

solving-strategy: "Iterate and modify"
algorithm-name: "Simple iteration and modification"

core-idea: "Find the first '6' in the number and change it to '9' to maximize the number."

observations:
  - "The highest impact change is converting a '6' to a '9'."
  - "Only one digit needs to be changed to potentially maximize the number."

pattern-recognition:
  why-this-pattern: "Convert to string to easily manipulate individual digits."

alternative-approaches:
  - "Convert directly without intermediate array."

why-not-alternatives: "Using a character array simplifies handling each digit."

window-details:
  window-type: "array iteration"
  expand-condition: "searching for first '6'"
  shrink-condition: "first change made"
  answer-update-condition: "conversion after small change"

data-structures:
  - "character array"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: "character array of digits"

invariants:
  - "Change only the first '6'."

edge-cases:
  - "All 9s in the number."
  - "Single digit number."

dry-run-example: "num=6699 initially becomes 9699 after converting the first '6'."

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Changing more than one digit unnecessarily."

implementation-notes:
  - "Convert to character array for easy digit manipulation."

confidence: "High"
difficulty-reason: "Understanding string manipulation and simple logical iteration."

learning-outcome:
  - "String manipulation can efficiently solve digit modification problems."

similar-problems:
  - ""

follow-up-questions:
  - "What if the digits could be other values beyond 6 and 9?"

solution-summary: "Convert the number to a string, change the first '6' to '9' for maximum result, and convert back to integer."
*/
