# Search Insert Position (Easy)

https://leetcode.com/problems/search-insert-position/

## Solution (Python3)

```python3
from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left
```

## Explanation

The solution leverages binary search to achieve O(log n) runtime complexity. We initialize two pointers, `left` and `right`, at the beginning and end of the array, respectively. The loop continues until `left` exceeds `right`. At each iteration, we calculate the mid-point and compare it with the target.

- If `nums[mid]` equals the target, we return `mid`.
- If `nums[mid]` is less than the target, shift `left` to `mid + 1` (target must be on the right side).
- If `nums[mid]` is greater, shift `right` to `mid - 1` (target must be on the left side).

Finally, if the target is not found, `left` will indicate the correct insertion position.
