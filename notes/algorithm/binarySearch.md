# Binary Search

Binary search is a search algorithm that runs in **O(log(n))** in the worst case, where n is the size of the search space. For binary search to work, your search space usually needs to be sorted. Binary search trees, which we looked at in the trees and graphs chapter, are based on binary search.

What binary search can do given an array:
* Find the index of x if it is in arr in O(logn)
* Find the first or the last index in which x can be inserted to maintain array sorted in O(logn)

## Implementation

### Search for index of x **WITHOUT** duplicates

* Sort the array.
* Declare left = 0, right = array.size() - 1
* while(left<=right)
  * get mid = (right-left)/2 + left, or (left+right)/2 -> (right-left) to avoid overflow in Java or C++
  * if mid == x, return mid;
  * else if mid > x, right = mid-1
  * else left = mid+1
* if get out of while, **left is the index x needs to be inserted** -> when left == right, left always ends up at the index of where the x should be.

```cpp
int binarySearch(vector<int>& arr, int target){
  int left = 0, right = arr.size()-1;
  while(left<=right){ // add equality left == right condition to make sure all elements are visited
  // when use condition left<=right, the if-else below should always move left or right one position away from mid to make sure the logic doesn't gridlock.
    int mid = left + (right-left)/2;
    if(arr[mid] == target){
      return mid;
    }else if(arr[mid] > target){
      right = mid-1;
    }else{
      left = mid+1;
    }
  }
  return left;
}
```

### Search for left most index of x **WITH** duplicates
```cpp
int binarySearch(vector<int>& arr, int target){
  int left = 0, right = arr.size(); // note that right starts at the end of the array
  while(left<right){ // avoid equality to prevent overshoot
    int mid = left + (right-left)/2;
    if(arr[mid] >= target){
      right = mid;
    }else{
      left = mid+1;
    }
  }
  return left;
}
```

### Search for right most insertion index(right most x index + 1) of x **WITH** duplicates
```cpp
int binarySearch(vector<int>& arr, int target){
  int left = 0, right = arr.size(); // note that right starts at the end of the array
  while(left<right){ // avoid equality to prevent overshoot
    int mid = left + (right-left)/2;
    if(arr[mid] <= target){
      left = mid+1;
    }else{
      right = mid;
    }
  }
  return left;
}
```

### Search the solution space
There is a more creative way to use binary search - on a solution space/answer. A very common type of problem is "what is the max/min that something can be done". 

The process is as follows:
* First, we establish the possible solution space by identifying the minimum possible answer and the maximum possible answer.
* Next, we binary search on this solution space. For each mid, we perform a check to see if the task is possible. Depending on the result, we halve the search space. Eventually, we will find the threshold.
* The complexity is O(n * logk). Where k is the solution space, and O(n) is to determine if mid is a feasible solution.

Examples of looking for minimum:
```cpp
int binarySearch(){
  int left, right;
  while(left<=right){  // we can use quality here, but the conditions below will always move.
    int mid = left + (right-left)/2;
    if(checkMidCanSatisfyCondition(mid)){
      right = mid - 1; // even if the mid is already the min, we still move right because we are returning left as the answer at the end. This is just to trigger the left == right condition to move left 1 position up.
    }else{
      left = mid + 1;
    }
  }
  return left;
}
```

Examples of looking for maximum:
```cpp
int binarySearch(){
  int left, right;
  while(left<=right){  // we can use quality here, but the conditions below will always move.
    int mid = left + (right-left)/2;
    if(checkMidCanSatisfyCondition(mid)){
      left = mid + 1;
    }else{
      right = mid - 1;
    }
  }
  return right; // returning right instead of left;
}
```