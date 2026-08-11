/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        prepareStack(nestedList);
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger current = stack.peek();
            if (current.isInteger()) {
                return true;
            }
            stack.pop();
            prepareStack(current.getList());
        }
        return false;
    }
}

// Your NestedIterator object will be instantiated and called as such:
// NestedIterator i = new NestedIterator(nestedList);
// while (i.hasNext()) v[f()] = i.next();



/*
problem-title: "Flatten Nested List Iterator"
problem-id: "341"
problem-link: "https://leetcode.com/problems/flatten-nested-list-iterator/"

problem-level: "Medium"
problem-category: "Design"
problem-area: "Algorithm"
tags: ["Iterator", "Nested List"]

solving-strategy: "Using a stack to store NestedInteger objects and manage iteration."
algorithm-name: "Stack-Based Iteration"

core-idea: "Use a stack to iterate through the nested list. Push all elements onto the stack initially. As you iterate, pop elements and process based on whether they are integers or lists."

observations:
  - "NestedInteger can either be an integer or a list."
  - "Use stack to manage the current position in the list."

pattern-recognition:
  why-this-pattern: "The use of a stack allows us to manage nested structures efficiently by processing in a LIFO manner."

alternative-approaches:
  - "Recursive flattening of the list and storing in an ArrayList."

why-not-alternatives: "Using a stack offers an on-demand approach, using less memory and allowing lazy evaluation."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Stack"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "Stack contains elements to be processed next."

edge-cases:
  - "Empty nested list."
  - "Nested lists contain only other lists without integers."

dry-run-example: ""

complexity:
  time: "O(n)"
  space: "O(n)"

optimization:
  from: "Recursive flattening of the entire list upfront."
  to: "Using a stack for lazy flattening."

mistakes-to-avoid:
  - "Ensure that the stack is populated by lists in reverse order."

implementation-notes:
  - "Use stack.peek() to check top element for efficient iteration."

confidence: "High"
difficulty-reason: "Stack management and handling nested structure dynamically."

learning-outcome:
  - "Using stacks for managing nested iterations efficiently."

similar-problems:
  - "Implementing Iterators for other nested structures."

follow-up-questions:
  - "How would this change if the list could contain other data types?"

solution-summary: "This solution uses a stack to manage iteration through nested lists, allowing efficient on-demand retrieval of integers."
*/
