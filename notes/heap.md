# Heap

## Relation with Binary Tree
Heap is the array representation of a complete binary tree.
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

## When to create your own heap
Every language has their own priority queue implementation, but it usually only support add and poll. 
If you want to change a number inside the array or doing something fancy, you need to create your own heap.