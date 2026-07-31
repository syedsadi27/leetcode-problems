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
 * problem-title: "Valid Phone Numbers"
 * problem-link: "https://leetcode.com/problems/valid-phone-numbers/"
 * 
 * problem-level: "Easy"
 * problem-category: "Reading and Writing Files"
 * problem-area: "Regex"
 * tags: ["File Handling", "Regular Expressions"]
 * 
 * solving-strategy: "Use regular expressions to match phone number patterns."
 * algorithm-name: "Regex Matching"
 * 
 * core-idea:
 * "Use regex patterns to check each line for valid phone number formats and print valid ones."
 * 
 * observations:
 * - "Phone numbers must match specific patterns."
 * - "Lines in file have no leading or trailing spaces."
 * 
 * pattern-recognition:
 * why-this-pattern:
 * "Regex is suitable for pattern matching tasks like validating phone numbers."
 * 
 * alternative-approaches:
 * - "Manual string parsing and validation without regex."
 * 
 * why-not-alternatives:
 * "Regex provides a concise and efficient way to express and validate complex string patterns."
 * 
 * window-details:
 * window-type: ""
 * expand-condition: ""
 * shrink-condition: ""
 * answer-update-condition: ""
 * 
 * data-structures:
 * - ""
 * solution-summary:
 * "The solution reads each line from the file and uses regex to identify and print only valid phone numbers."
 */
