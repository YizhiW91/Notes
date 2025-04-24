# Heap
A heap is a container that stores elements, and supports the following operations:
* Add an element in O(logn)
* Remove the minimum element in O(logn)
* Find the minimum element in O(1)

## Relation with Binary Tree
Heap is the array representation of a **complete binary tree**.
* A complete binary tree is a binary tree that strictly follow left to right population. All levels are fully populated, except the last level, which also needs to follow left to right population.

## Calculation with complete binary tree
* Assuming the total size of the tree is N, size of the last level is approximately N/2, the size of levels above the last are approximately N/4, N/8, ...
* Given node position **i**, the left child is **2i+1**, the right child is **2i+2**.
* Given node posttion **i**, the parent location is **(i-1)/2**.
* The position of starting node of ith level is **2^(i-1) -1** 

## Heap Insert
The operation of inserting a number to the correct position of a complete binary tree. 
The process is to put the number at certain location, and keep moving it up. The process complexity is O(LogN) because it is just the depth of the tree.

## Heapify
The operation of inserting a number to the correct position of a complete binary tree. 
The process is to put the number at certain location, and keep moving it down. The process complexity is O(LogN) because it is just the depth of the tree.

## In place array to heap
This process takes O(n) time, by using bottom-up heap construction.
Only the nodes closer to the root need more sifting (log n), but there are fewer of them.

## When to create your own heap
Every language has their own priority queue implementation, but it usually only support add and poll. 
If you want to change a number inside the array or doing something fancy, you need to create your own heap.

## C++ implementation of heap
```cpp
priority_queue<int> heap; // max heap by default

// add
heap.push(1);
heap.push(2);

// peek
heap.top();

// removal
heap.pop();

// Get size
heap.size();

// Bonus: convert a vector into a heap in linear time
// This process takes O(n) time by skipping the last layer of leaf nodes.
priority_queue<int> heap(nums.begin(), nums.end()); 

// to implement a min heap:#include <queue>
std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;
```

## Java implementation of heap
```java
// In Java, we will use the PriorityQueue interface and the
// PriorityQueue implementation. By default, this implements
// a min heap
PriorityQueue<Integer> heap = new PriorityQueue<>();

// Add to heap
heap.add(1);
heap.add(2);
heap.add(3);

// Check minimum element
heap.peek(); // 1

// Pop minimum element
heap.remove(); // 1

// Get size
heap.size(); // 2

// Bonus: if you want a max heap instead, you can pass
// Comparator.reverseOrder() to the constructor:
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
```

## 2-heaps
Using multiple heaps is uncommon and the problems that require it are generally on the harder side. 
If a problem involves finding a **median**, it's a good thing to think about. 