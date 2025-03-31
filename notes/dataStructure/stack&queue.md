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