# Binary Search

Binary search is a search algorithm that runs in **O(log(n))** in the worst case, where n is the size of the search space. For binary search to work, your search space usually needs to be sorted. Binary search trees, which we looked at in the trees and graphs chapter, are based on binary search.

What binary search can do given an array:
* Find the index of x if it is in arr in O(logn)
* Find the first or the last index in which x can be inserted to maintain array sorted in O(logn)

## Implementation
Search for index of x. **Should only be used on arrays without duplicates.**

* Sort the array.
* Declare left = 0, right = array.size() - 1
* while(left<=right)
  * get mid = (right-left)/2 + left, or (left+right)/2
  * if mid == x, return mid;
  * else if mid > x, right = mid-1
  * else left = mid+1
* if get out of while, left is the index x needs to be inserted