# Stack

## Operation
* Push
* Pop
* Peek
* Size
* isEmpty


## Common implementation
* Can be implemented via LinkedList, Array, etc.

When implemented with vector:
```cpp
vector<int> stack;
stack.push_back();
stack.pop_back();
stack[stack.size()-1];
stack.empty();
stack.size();
```

# Queue
There aren't a lot of problems where a queue shines on its own. Mainly used for BFS in trees.
## Operation
* Push
* Pop
* Peek
* Size
* isEmpty
* front

## Implementataion

Common implementation is to use a double linked list with head and tail tracked.

# Monotonic

A monotonic stack or queue is one whose elements are always sorted. It can be sorted either ascending or descending, depending on the algorithm. Monotonic stacks and queues maintain their sorted property by removing elements that would violate the property before adding new elements. For example, let's say you had a monotonically increasing stack, currently stack = [1, 5, 8, 15, 23]. You want to push 14 onto the stack. To maintain the sorted property, we need to first pop the 15 and 23 before pushing the 14 - after the push operation, we have stack = [1, 5, 8, 14].

## Common Tricks

* Subarray min/max.
  * One common question using monotonic is to calculate the sum of all subarray min/max. Subarray is the contiguous sections in a array. Usually, this type of question requires to keep a monotonic increase/decrease stack. The stack top should be the current max/min's **index**. 
  * Using the monotonic increase stack for tracking min as an example. If current<=stack top, we should pop stack top, and calculate how many subarrays using stack top as the min. 
  * The core is to calculate `(# of subarrays where stack top is the min or max)`.The formula is (right - mid) * (mid - left). 
    * mid is the index of stack top
    * left is the index of prev element that's strictly less than or greater than stack top. If doesn't exist, use -1.
    * right is the index of next element that's strictly less than or greater than stack top. If doesn't exist, use n.
  * Let’s say: nums = [3, 1, 2]. Focus on element 1 at index 1. As a minimum, we want to know how many subarrays have 1 as the minimum. On the left, there's no element smaller than 1, so left = -1. On the right, 2 is larger, so right = 2. The answer is (1-(-1)) * (2 - 1) = 2.

Examples:
Q907. Sum of subarray Minimums
  * Monotonic. Should come up with O(n2) solution. O(n) solution needs some thoughts.

Q2104. Sum of Subarray Ranges
  * Another typical subarray monotonic question. Similar to Q907.

Q1063. Number of Valid Subarrays
  * Exactly the same question as above.