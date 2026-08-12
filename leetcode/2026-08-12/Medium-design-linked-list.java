class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */



/*
problem-title: "Design Linked List"
problem-id: "838"
problem-link: "https://leetcode.com/problems/design-linked-list/"

problem-level: "Medium"
problem-category: "Data Structure"
problem-area: "Linked List"
tags: ["Linked List", "Design"]

solving-strategy: "Iterative"
algorithm-name: "Singly Linked List Implementation"

core-idea: "Implement a singly linked list with methods to get, add, and delete nodes."

observations:
  - "Each operation runs in O(n) time due to traversal."
  - "Node structure allows for dynamic list growth."

pattern-recognition:
  why-this-pattern: "Linked list operations naturally involve traversals to manage node connections."

alternative-approaches:
  - "Use a doubly linked list for potentially faster mid-list operations."

why-not-alternatives: "Singly linked list is simpler and sufficient for required operations."

window-details:
  window-type: ""
  expand-condition: ""
  shrink-condition: ""
  answer-update-condition: ""

data-structures:
  - "Linked List"

key-variables:
  left: ""
  right: ""
  currentSum: ""
  answer: ""

invariants:
  - "The linked list always has 'size' nodes."

edge-cases:
  - "Empty list operations."
  - "Index out of bounds."

dry-run-example: "Add 3 at head, then 5 at tail, add 4 at index 1: [3, 4, 5]"

complexity:
  time: "O(n) for get, addAtIndex, deleteAtIndex; O(1) for addAtHead, addAtTail in average case"
  space: "O(1)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Ensure node pointers are correctly updated when adding/deleting."

implementation-notes:
  - "Maintain size for O(1) length checks."

confidence: "High"
difficulty-reason: "Requires manual pointer management without built-in LinkedList."

learning-outcome:
  - "Understanding linked list operations and edge cases."

similar-problems:
  - "Reverse Linked List"
  - "Merge Two Sorted Lists"

follow-up-questions:
  - "How would this change with a doubly linked list?"

solution-summary: "This solution provides a basic singly linked list that supports adding, getting, and deleting nodes with iterative traversal."
*/
