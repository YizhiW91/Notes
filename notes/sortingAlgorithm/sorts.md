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

## Non-comparative Sorting - Radix Sort
The above sorting algorithms are all based on comparison. Non-comparative sorting seeks for finding the pattern in the given array and use it to recreate or rearrange the array without comparing all elements in the array.

Radix sort is one of the them. The idea of radix sort is to sort digit by digit. Sort algorithm goes from smallest digit to highest digit. Put each digit into a bucket and pour them out accordingly.

Pseudo code for an interesting implementation without using 10 buckets.
```Java
public static void radixSort(int[] arr, int l, int r){
  int maxValue = getMax(arr, l, r);
  int maxDigit = getMaxDigit(maxValue);
  for(int d = 1; d<=maxDigit; d++){
      int[] counter = new int[10];
      // put numbers into counter
      for(int i = l; i<= r; i++){
          int numInDigit = getDigit(arr[i], d);
          counter[numInDigit]++;
      }
      // convert counter into a less than or equal to count array by accumulative sum from the beginning
      // for example, the counter is [0,1,2,1,0,0,0,0,0,0]
      // after the change, value goes[0,1,3,4,4,4,4,4,4,4], meaning how many numbers have numbers in this digit less than or equal to the position index
      for(int i = 1; i<10; i++){
          counter[i] += counter[i-1];
      }
      // pour the array(i, j) from the end to start and put them into the helper array
      int[] helper = new int[r-l+1];
      for(int i = r; i>=l; i--){
          int numInDigit = getDigit(arr[i], d);
          int pos = counter[numInDigit] - 1;
          helper[pos] = arr[i];
          counter[numInDigit]--;
      }
      // assign helper back
      for(int i=l; i<=r; i++){
          arr[i] = helper[i-l];
      }
  }
}
```

The complexity of the algorithem should be **O(N)**, space complexity should also be **O(N)**.