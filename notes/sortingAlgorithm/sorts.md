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
  * 求小和.

## Quick Sort
* The process is to find one number(could be random), then put the number in the array so that left and right side are less than and greater than the number. Then do the same for the two parts.
* Time complexity varies based on sampling:
  * The Best case scenario: O(nlogN). The best scenario is the number selected always equally split. Perfect dichotomy.
  * The Worst case scenario: O(n2). The worst scenario is the number selected always go to the end of the array, causing sorting the whole array every time.
* Similar questions:
  * Sort Colors(Dutch flag) #75