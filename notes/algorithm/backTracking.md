# BackTracking

Backtracking is a way to efficiently run through all possibilities in a problem, like a **structured brutal force** method by recursion and pruning out impossible routes early on. In an exhaustive search, we generate all possibilities and then check them for solutions. In backtracking, we prune paths that cannot lead to a solution, generating far fewer possibilities.

A hint of backtracking is when the question asks to find **ALL** of something. Usually, if the input is **relatively small n<=~15**, it is a good hint of using backtracking. As most of the BT questions have exponential time complexities.

## Implementation

Backtracking is almost always implemented with recursion.

Here is the pseudo code of process some value curr:

function backtrack(curr) {
    if (condition meet) {
        Increment or add to answer
        return
    }

    for (iterate over input) {
        Modify curr
        backtrack(curr)
        Undo whatever modification was done to curr -> this is the important part so that we don't need to copy the curr everytime when it changes.
    }
}

### Typical Question: Gnerate Something

One common type of problem that can be solved with backtracking are problems that ask you to generate all of something.

Example: Q78. Subsets:
Given an integer array nums of unique elements, return all subsets in any order without duplicates.
For example, given nums = [1, 2, 3], return [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

```cpp
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> v;
        vector<vector<int>> ans;
        int pos = 0;
        backtrack(ans, v, nums, pos);
        return ans;
    }

    void backtrack(vector<vector<int>>& ans, vector<int>& v, vector<int>& nums, int pos){
        if(pos == nums.size()){
            ans.push_back(v); // In c++, push_back makes a copy. In other languages, we need to manually make a copy of v before push back to ans.
            return;
        }
        backtrack(ans, v, nums, pos+1);
        v.push_back(nums[pos]);
        backtrack(ans, v, nums, pos+1);
        v.pop_back(); // This is the key step to make sure every backtrack step processes the same v.
    }
};
```
