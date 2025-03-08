# Array & String

## Difference in Language

### String
* Java and Python has immutable String, meaning foo = "abc", if one needs to change it to "abd", the whole string needs to be recreated.
* C++ has mutable String.

### Array
* Array has fixed length or dynamic. Most of the language uses dynamic length. The space allocation usually happens at max capacity by doubling the capacity, etc. vector in C++ or ArrayList in Java.


## Operation Complexity

| Ops  | Array/List | String(Immutable) |
|---|---|---|
| Appending to end | *O(1) | O(n) |
| Pop from end | O(1) | O(n)
| Insert, not from end | O(n) | O(n)
| Delete, not from end | O(n) | O(n)
| Modify an element | O(1) | O(n)
| Random Access | O(1) | O(1)
| Check if element exists | O(n) | O(n)

### Common Techniques

#### Two Pointers
Two pointers is an extremely common technique used to solve array and string problems. It involves having two integer variables that both move along an iterable. In this article, we are focusing on arrays and strings. This means we will have two integers, usually named something like i and j, or left and right which each represent an index of the array or string.

##### Tricks
* To stop at the middle of an array including middle element: (n-1)/2
* To stop at the middle of an array excluding middle element: n/2-1

##### Two pointers for reversing an array/string.
* LC: 167. Two Sum II - Input Array Is Sorted
* LC: Reverse String
* LC: Squares of a Sorted Array

##### Two pointers for traverse two arrays. 
* LC: 392. Is Subsequence.
* LC: Squares of a Sorted Array

#### Sliding Window
It is a common skill for a group of problems which requires you to manipulate two pointers, **left** and **right** to find the valid **subarray** from the given input. The subarray is a contiguous section of the array.

Usually, the problem has two conditions:
* A constraint metric. This is some attribute of a subarray. It could be the sum, the number of unique elements, the frequency of a specific element, or any other attribute.
* A numeric restriction on the constraint metric. This is what the constraint metric should be for a subarray to be considered valid.

The structure to solve the problem is usually like this:
* Iterate the right pointer over the array.
* If subarray [left, right] is not valid, while loop to keep move the left pointer up until the new [left, right] is valid again.
  
Note:
* The tricky part of sliding window is the management of the left pointer, whether to include it or not. Usually, if you want to include left pointer, initialize it with 0. If you do not want to include it, initialize it with -1.

##### Examples
* Example 1: Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum is less than or equal to k. This is the problem we have been talking about above. We will now formally solve it.

```cpp
int findLength(vector<int>& nums, int k) {
    int left = 0, right = 0, ans = 0, curr = 0;
    while(right<nums.size()){
        curr += nums[right];
        while(curr>k){ // always stop at curr = 0
            curr-=nums[left]
            left++;
        }
        ans = max(ans, right-left+1)
        right++;
    }
    return ans;
}
```

* Example 2: You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.
```cpp
int findLength(string s) {
    int left = 0, count = 0, ans = 0;
    for(int right = 0; right<s.size(); right++){
        if(s[right] == '0') 
            count++;
        while(count>1){
            if(s[left] == '0') 
                count--;
            left++;
        }
        ans = max(right - left + 1, ans);
    }
    return ans;
}
```

* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

```cpp
int numSubarrayProductLessThanK(vector<int>& nums, int k) {
    if(k<1) return 0;

    int l = 0, curr = 1, ans = 0;
    for(int r = 0; r<nums.size(); r++){
        curr*=nums[r];
        while(curr>=k){
            curr/=nums[l];
            l++;
        }
        ans += (r-l+1);
    }
    return ans;
}
```

* Example 3: 713. Subarray Product Less Than K.

Given an array of positive integers nums and an integer k, 
return the number of subarrays where the product of all the elements in the subarray is strictly less than k.
For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8. The subarrays with products less than k are:

[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]

```cpp
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if(k<1) return 0;

        int l = 0, curr = 1, ans = 0;
        for(int r = 0; r<nums.size(); r++){
            curr*=nums[r];
            while(curr>=k){
                curr/=nums[l];
                l++;
            }
            ans += (r-l+1);
        }
        return ans;
    }
```

643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
Any answer with a calculation error less than 10-5 will be accepted.

Note: For fixed length window problem, we don't even need left pointer.

```cpp
double findMaxAverage(vector<int>& nums, int k) {
    if(nums.size()<k) return 0;
    
    int left = 0, right = 0; 
    double sum = 0, ans = 0; 
    for(right = 0; right<k ; right++){
        sum += nums[right];
    }
    
    for(right = k; right<nums.size(); right++){
        sum = sum + nums[right] - nums[left++];
        ans = max(ans, sum);
    }
    return ans/k;
}
```

2090. K Radius Subarray Averages

You are given a 0-indexed array nums of n integers, and an integer k.
The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

```cpp
vector<int> getAverages(vector<int>& nums, int k) {

    vector<int> res(nums.size(), -1);
    int l =0;
    long long sum  =0;
    int ind = k;
    for(int i =0 ; i< nums.size(); ++i){
        sum += nums[i];
        if(i >= k*2){
            res[ind++] = sum/(2*k+1);
            sum -= nums[l++]; // This is a smart move. Assign the value to ans first then reduce the left.
        }
    }
    return res;
}
```