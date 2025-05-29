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


### More Constrained Backtracking Question
Example 39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


```cpp
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> selected;
        backtracking(selected, candidates, 0, ans, target);
        return ans;
    }

    void backtracking(vector<int>& selected, vector<int>& candidates, int idx, vector<vector<int>>& ans, int target){
        if(target == 0){
            ans.push_back(selected);
            return;
        }

        for(int i=idx; i<candidates.size(); i++){
            int c = candidates[i];
            if(target>=c){ 
                // this is the core. When we select C, we run backtrack with a new target = target - c          
                selected.push_back(c);
                backtracking(selected, candidates, i, ans, target-c);
                // when we don't select c, we move to the next candidate.
                selected.pop_back();
            }
        }
    }
};
```