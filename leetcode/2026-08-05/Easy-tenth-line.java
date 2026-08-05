import java.io.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    String line;
    int count = 0;
    while ((line = br.readLine()) != null) {
      count++;
      if (count == 10) {
        System.out.println(line);
        return;
      }
    }
    br.close();
  }
}

/*
 * problem-title: "Tenth Line"
 * problem-id: "195"
 * problem-link: "https://leetcode.com/problems/tenth-line/"
 * 
 * problem-level: "Easy"
 * problem-category: "File"
 * problem-area: ""
 * tags: []
 * 
 * solving-strategy:
 * "Read line-by-line and count until the 10th line is reached."
 * algorithm-name: "Line Counting from file"
 * 
 * core-idea:
 * "Iterate through each line of the file and count until the 10th line is reached. If reached, print it; otherwise end without output."
 * 
 * observations:
 * - "Reading files line-by-line is efficient for handling text files."
 * - "Check if line exists to avoid issues with shorter files."
 * 
 * pattern-recognition:
 * why-this-pattern:
 * "Reading line by line allows efficient file processing, especially when specific lines need to be accessed."
 * 
 * alternative-approaches:
 * - "Load all lines into a list and directly access the 10th line."
 * 
 * why-not-alternatives:
 * "Loading all lines can be high in memory if the file is large. Line-by-line reading is more memory efficient."
 * 
 * window-details:
 * window-type: ""
 * expand-condition: ""
 * shrink-condition: ""
 * answer-update-condition: ""
 * 
 * data-structures:
 * - "BufferedReader"
 * 
 * key-variables:
 * left: ""
 * right: ""
 * currentSum: ""
 * answer: ""
 * 
 * invariants:
 * - "Each new line read increments the count by one."
 * 
 * edge-cases:
 * - "File with less than 10 lines."
 * - "Empty file."
 * 
 * dry-run-example:
 * "Traverse 10 lines in file.txt and ensure the output is 'Line 10'."
 * 
 * complexity:
 * time: "O(N)"
 * space: "O(1)"
 * 
 * optimization:
 * from: ""
 * to: ""
 * 
 * mistakes-to-avoid:
 * - "Forgetting to close the file reader."
 * 
 * implementation-notes:
 * - "Read each line within a loop and check line count."
 * 
 * confidence: "High"
 * difficulty-reason: "Simple file reading with a line counter."
 * 
 * learning-outcome:
 * - "Handling file I/O effectively with Java."
 * 
 * similar-problems:
 * - ""
 * 
 * follow-up-questions:
 * - "How would you handle access to multiple specific lines in a large file?"
 * 
 * solution-summary:
 * "Read file line by line, counting up to the desired line, and output if it exists."
 */
