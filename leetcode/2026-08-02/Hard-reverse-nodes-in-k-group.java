/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, next = dummy, prev = dummy;
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
}



/*
problem-title: "Reverse Nodes in k-Group"
problem-id: "25"
problem-link: "https://leetcode.com/problems/reverse-nodes-in-k-group/"

problem-level: "Hard"
problem-category: "Linked List"
problem-area: "Data Structures"
tags: ["Linked List", "Recursion"]

solving-strategy: "Iterative"
algorithm-name: "Reverse In Groups"

core-idea: "Iteratively reverse nodes in k groups using pointers manipulation."

observations:
  - "We need to reverse the linked list nodes in groups of k."
  - "If nodes left at the end are less than k, do not reverse them."

pattern-recognition:
  why-this-pattern: "Linked list transformation is best approached with pointer manipulation techniques."

alternative-approaches:
  - "Recursive method."

why-not-alternatives: "Iterative approach minimizes stack space usage."

window-details:
  window-type: "Fixed Size"
  expand-condition: "Always move k nodes forward."
  shrink-condition: "After reversing, reset group start point."
  answer-update-condition: "Update list connections after each k-group reversal."

data-structures:
  - "Linked list"

key-variables:
  left: "prev"
  right: "next"
  currentSum: "N/A"
  answer: "dummy.next"

invariants:
  - "Always ensure k nodes are available before reversal."

edge-cases:
  - "k is 1, no reversal needed."
  - "List is null."

dry-run-example: "Start with nodes [1,2,3,4,5], k=2. Reverse in pairs: [2,1,4,3,5]."

complexity:
  time: "O(n)"
  space: "O(1)"

optimization:
  from: "Recursive approach"
  to: "Iterative, eliminating recursive stack overhead."

mistakes-to-avoid:
  - "Not checking if a full group of k nodes is available before reversing."

implementation-notes:
  - "Use a dummy node to simplify head manipulation."

confidence: "High"
difficulty-reason: "Careful pointer manipulation and edge case handling required."

learning-outcome:
  - "Efficiently reverse nodes in groups using pointer manipulation."

similar-problems:
  - "Reverse Linked List"
  - "Swap Nodes in Pairs"

follow-up-questions:
  - "How would you handle k being larger than list size?"

solution-summary: "Efficiently reverse linked list nodes in fixed-size groups by iteratively manipulating node connections."
*/
