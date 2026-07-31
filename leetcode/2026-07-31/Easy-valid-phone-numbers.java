import java.io.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String line;
        Pattern pattern = Pattern.compile("^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$");
        while ((line = br.readLine()) != null) {
            if (pattern.matcher(line).matches()) {
                System.out.println(line);
            }
        }
        br.close();
    }
}



/*
problem-title: "Valid Phone Numbers"
problem-id: "193"
problem-link: "https://leetcode.com/problems/valid-phone-numbers/"

problem-level: "Easy"
problem-category: "Reading and Writing Files"
problem-area: "Regex"
tags: ["File Handling", "Regular Expressions"]

solving-strategy: "Use regular expressions to match phone number patterns."
algorithm-name: "Regex Matching"

core-idea: "Use regex patterns to check each line for valid phone number formats and print valid ones."

observations:
  - "Phone numbers must match specific patterns."
  - "Lines in file have no leading or trailing spaces."

pattern-recognition:
  why-this-pattern: "Regex is suitable for pattern matching tasks like validating phone numbers."

alternative-approaches:
  - "Manual string parsing and validation without regex."

why-not-alternatives: "Regex provides a concise and efficient way to express and validate complex string patterns."

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
  answer: ""

invariants:
  - "Each input line should be considered separately."

edge-cases:
  - "Non-numeric characters."
  - "Invalid length strings."

dry-run-example: "Given an input line '123-456-789', it would not match as it's not in a valid format."

complexity:
  time: "O(n) - We read each line once where n is the number of lines."
  space: "O(1) - Pattern matching does not consume extra space proportionate to input size."

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Not closing the file reader after use."

implementation-notes:
  - "Use BufferedReader for efficient line-by-line file reading."

confidence: "The solution efficiently identifies valid phone numbers using regex."
difficulty-reason: "Regex provides concise pattern matching but requires careful pattern design."

learning-outcome:
  - "Understand how to apply regex for pattern matching in a file."

similar-problems:
  - "Find Phone Numbers in a Text"

follow-up-questions:
  - "How would the solution change if numbers could contain spaces or be separated by different delimiters?"

solution-summary: "The solution reads each line from the file and uses regex to identify and print only valid phone numbers."
*/
