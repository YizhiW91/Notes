# Sorting Algorithm

## Bubble Sort
* Complexity not related to how data is presented.

## Insertion Sort
* Complexity related to data representation.


## Merge Sort
* Complexity based on master theorem - O(nlogN).
* The recursive process took advantage of preserve order from the previous actions.
* Similar questions:
  * Count of Smaller Numbers After Self. #315
  * 求小和: 求所有比当前数左边小的数之和。
  * 逆序对：左边的数如果比右边的数大，则两个数构成逆序队， 求所有逆序对。

## Quick Sort
The process is to find one number(could be random), then partition the array so that left side is less than or equal to and right side is greater than the number. Then do the same for the two parts.
The coding idea is to imagine the less and larger number area, and expand the area accordingly.
* Time complexity varies based on sampling:
  * The Best case scenario: O(nlogN). The best scenario is the number selected always equally split. Perfect dichotomy.
  * The Worst case scenario: O(n2). The worst scenario is the number selected always go to the end of the array, causing sorting the whole array every time.
* Improvements of quick sort
  * Phase1 - Always select the last position number to sort.
  * Phase2 - Randomly select number to sort.
  * Phase3 - Randomly select number to sort, and put the numbers equal to the selected one in the middle and only sort the rest two part.
* Similar questions:
  * Sort Colors(Dutch flag) #75

## Heap Sort
The soring process relies on heap operation. Pseudo code:
```java 
int[] arr;
int heapSize = 0
// First step, heapInsert the array to turn into maxHeap
while(heapSize< arr.length){
  heapInsert(arr, heapSize++)
}
// then swap the maxValue of the heap to end, reduce the size by 1 and reheapify the remaining until size reaches 0 
while(heapSize > 0){
  swap(arr, 0, heapSize--)
  heapify(arr, 0, heapSize)
}
```
### Complexity
The process of converting arr to maxHeap is a **O(NlogN)** operation, and pop the value to make a sorted array is also **O(NlogN)**. 
Combined the complexity is **O(NlogN)**. Space complexity is O(1).
### Improvement
The one improvement on the traditional heap sort is to use heapify instead of heapInsert to create an max heap. To create a max/min heap 
from an array is an O(N) level operation. This change will not affect the overall complexity of the heap sort.
### Similar Questions
 * Sort a nearly sorted array(k sorted array)