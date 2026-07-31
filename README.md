# LeetCode Daily — Solve & Commit

This repository is maintained automatically by an n8n workflow that picks unsolved LeetCode problems each day, solves them with AI, and commits them here.

## Commit message format

Every solution commit uses the format:

    <problem_title>_<solved_date>

Example: `Two Sum_2026-07-31`

## Solution file format

Each solution is committed to:

    leetcode/<solved_date>/<Difficulty>-<title-slug>.java

The file contains two parts:

1. A complete, self-contained Java solution matching LeetCode's required class/method signature (runnable exactly as pasted into LeetCode's editor).
2. A metadata block appended at the bottom as a `/* ... */` comment. The metadata is YAML with keys such as `problem-title`, `problem-id`, `problem-link`, `problem-level`, `problem-category`, `tags`, `solving-strategy`, `core-idea`, `complexity` (time/space), `edge-cases`, `mistakes-to-avoid`, `similar-problems`, and `solution-summary`.

Example layout of a solution file:

    class Solution {
        // ... Java solution ...
    }



    /*
    problem-title: "Two Sum"
    problem-id: "1"
    problem-link: "https://leetcode.com/problems/two-sum/"
    problem-level: "Easy"
    ... rest of the YAML metadata ...
    */

## progress.md

`progress.md` tracks every solved problem, grouped by the date it was solved. Each entry is listed as:

    - <problem title> - (<problem category>)

How it is updated: after each daily commit, the workflow reads the full history of solved problems from its data store and regenerates `progress.md` from scratch, grouping entries by `solved_date` (newest first) and showing a running total. This means `progress.md` always reflects the complete, de-duplicated solved list — you do not edit it by hand.
