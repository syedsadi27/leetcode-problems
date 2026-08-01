# Write your MySQL query statement below
SELECT name
FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT DISTINCT sales_id
    FROM Orders
    WHERE com_id IN (
        SELECT com_id
        FROM Company
        WHERE name = 'RED'
    )
);



/*
problem-title: "Sales Person"
problem-id: "607"
problem-link: "https://leetcode.com/problems/sales-person/"

problem-level: "Easy"
problem-category: "Database"
problem-area: "SQL"
tags: ["SQL", "Join", "Subquery"]

solving-strategy: "Subquery Filtering"
algorithm-name: "Subquery Exclusion"

core-idea: "Use a subquery to filter out salespersons with orders from the company named 'RED'."

observations:
  - "The problem requires finding salespersons without orders related to a specific company."
  - "We can use subqueries to exclude unwanted salespersons."

pattern-recognition:
  why-this-pattern: "In SQL, subqueries are effective for exclusion or filtering data based on conditions."

alternative-approaches:
  - "Use JOIN and LEFT JOIN with filtering for nulls."

why-not-alternatives: "Using subqueries is more direct and simplifies the exclusion logic in this case."

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
  - ""

edge-cases:
  - "Salesperson table has no entries."
  - "No orders for the company named 'RED'."

dry-run-example: "Using the provided table data, we find salespersons without orders linked to 'RED'."

complexity:
  time: "O(N)"
  space: "O(N)"

optimization:
  from: ""
  to: ""

mistakes-to-avoid:
  - "Forgetting to use DISTINCT in the subquery to avoid duplicates."

implementation-notes:
  - "Use IN to check membership in the list of sales_ids having orders with company 'RED'."

confidence: "High"
difficulty-reason: "The query requires only basic SQL operations with subqueries."

learning-outcome:
  - "Learned to effectively use subqueries to filter data in SQL."

similar-problems:
  - ""

follow-up-questions:
  - "How would this change if finding salespersons linked only to 'RED'?"

solution-summary: "The solution involves finding salespersons whose sales_id is not present in any orders linked to a company named 'RED'."
*/
