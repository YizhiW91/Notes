* Q557. Reverse Words in a String III
  * Try stringstream, reverse() in c++;
  * Try stringbuider in java;

* Q2000. Reverse Prefix of Word

* Q558. Move Zeroes
  * Try to resolve it in 5 minutes and minimize the code.

* Q209. Minimum Size Subarray Sum
  * Try sliding window
  * Try binary search
* Q560. Subarray Sum Equals K
  * Hash
* Q1248. Count Number of Nice Subarrays
  * Very similar.

* Q724. Find Pivot Index
  * Try to use O(1) space.

* Q303. Range Sum Query - Immutable
  * Create vector in C++.

* Q1832. Check if the Sentence is Pangram
  * Try the bit manipulation.
* Q268. Missing Number
  * Try the bit manipulation.

* Q1133. largest-unique-number 
  * Try the sort way

* Q52. Contiguous Array
  * Understand the solution.
    * Note the trick of sum 0.

* Q49. Group Anagrams
  * Try to think if there is a O(N*M) way

* Q2260. Minimum Consecutive Cards to Pick Up
  * Try sliding window solution

* Q3. Longest Substring Without Repeating Characters
  * Try shorter solution.

* Q3005. Count Elements With Maximum Frequency
  * Try to use one map and one traverse.

* Q451. Sort characters by frequency.
  * Note the immutability of the string.
  * Customize comparator

* Q2958. Length of Longest Subarray With at Most K Frequency
  * Try not use while loop in the for loop of sliding window.

Q930. Binary Subarrays With Sum
  * Try again, remember what approach to use when encountering the subarray and sum.
  * Try not use a hashmap

Q523. Closest Prime Numbers in Range
  * SOE practice.

Q2379. Minimum Recolors to Get K Consecutive Black Blocks
  * Try to solve it without while loop.

Q3208. Alternating Groups II
  * Try one pass. Very typical wrap around question.

Q3306. Count of Substrings Containing Every Vowel and K Consonants II
  * Solve it. Remember the sliding winding trick.

Q2529. Maximum Count of Positive Integer and Negative Integer
  * Good binary search question. Try the built-in function and self implemented method.

Q3356. Zero Array Transformation II
  * Difference array
  * Binary search 
  * Line swap

Q2226. Maximum Candies Allocated to K Children
  * Binary search

Q92. Reverse Linked List II
  * Write it in a cleaner manner and solve it within 10 mins
  * Note the position of prev, curr when starting the reverse and at the end of the reverse.

Q19. Remove Nth Node From End of List
  * Creating a head node before the actual linked list is a good approach.

Q82.  Remove Duplicates from Sorted List II
  * Try it again

Q2074. Reverse Nodes in Even Length Groups
  * Wasn't able to solve it, try again.

Q328. Odd Even Linked List
  * Try not to use the curr node.

Q707. Design Linked List
  * Try singly linked list;
  * Try doubly linked list;

Q3169. Count Days Without Meetings
  * Try to solve it, using Map.
  * Try to solve without additional space.
  
Q1047. Remove All Adjacent Duplicates In String
  * Try without stack in C++;

Q2033. Minimum Operations to Make a Uni-Value Grid
  * Try find median of the array.
  * Try without median, prefix sum.

Q71. Simplify Path
  * Remember how to split string.
  
Q739. Daily Temperatures
  * Think about the structure, what data structure mimics it. A bit hard.

Q2873. Maximum Value of an Ordered Triplet I
  * Try space O(n) and space O(1) approach
  * Space O(1) is tricky, like DP question. The current step is preparing for the next step

Q239. Sliding Window Maximum
  * Monotonic deque

Q1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
  * Very good question for explaining how monotonic works. 

Q496. Next Greater Element I
  * Stack.

Q901. Online Stock Span
  * monotonic stack.

Q1863. Sum of All Subset XOR Totals
  * Backtracking(recursive) to get the subset.

Q649. Dota2 Senate
  * The total round of votes is tricky.

Q232. Implement Queue using Stacks
  * Try the amortized O(1) solution.

Q1673. Find the Most Competitive Subsequence
  * Monotonic.

Q236. Lowest Common Ancestor of a Binary Tree
  * Check from bottom up.

Q111. Minimum Depth of Binary Tree
  * Try DFS and BFS.
  * Understand why BFS is superior and the limitation on DFS.

Q1944. Number of Visible People in a Queue
  * still monotonic, try not to overcomplicate it.

Q225. Implement Stack using Queues
  * Try pop O(n), push O(n)
  * Can you do it with 1 queue.


### Monotonic Subarray min/max
Q907. Sum of subarray Minimums
  * Monotonic. Should come up with O(n2) solution. O(n) solution needs some thoughts.

Q2104. Sum of Subarray Ranges
  * Another typical subarray monotonic question. Similar to Q907.

Q1063. Number of Valid Subarrays
  * Exactly the same question as above.

Q2398. Maximum Number of Robots Within Budget
  * Combination of moving window and monotonic.


Q103. Binary Tree Zigzag Level Order Traversal
  * The trick is just push the value to the ans stack with different direction.
  * Try to get clear about the rules of BFS in and out.
  * Try DFS

Q98. Validate Binary Search Tree.
  * Typical BST question, space O(1) solution.

Q701. Insert into a Binary Search Tree
  * Don't complicate things. For BST you can always insert a leaf node without breaking BSF rules.

Q200. Number of Islands
  * Understand the space and time complexity.

Q1466. Reorder Routes to Make All Paths Lead to the City Zero
  * Pay attention to the if condition during dfs.
Q1971. Find if Path Exists in Graph
  * Exact the same issue as above. When using DFS, make sure set seen after added element to stack to avoid duplicated visit. 
  * Disjoint set union

Q1557. Minimum Number of Vertices to Reach All Nodes
  * Don't over think.

Q1091. Shortest Path in Binary Matrix
  * handing multi-direction sub problems.
  * It is a smart way to handle set<pair<foo>> if pair is <row, col>. We can just use vector<vector<bool>> as seen;
  * Smart to add a count in the queue.

Q863. All Nodes Distance K in Binary Tree
  * A nice example of converting tree into graph.

Q542. 01 Matrix
  * Use 0 as start
  * Some performance consideration in c++
    * Try to use fixed size array like pair or tuple than vector. The former uses stack and the latter uses heap which is more expansive.

Q1129. Shortest Path ith Alternating Colors
  * Similar question as the one below, a bit simpler.
Q1293. Shortest Path in a grid with obstacles elimination
  * Tricky of how to track the seen. Need to think through.
    * The idea is if visiting a cell that has been visited, as long as the current remaining obstacle removal is greater than the previous visit, we should visit the cell again. The reason is if the cell has been visited, because it is BFS so the steps used to visit the cell is definitely <= the current step. However, if the current step requires less obs removal, we should still visit it.
Q.909 Snakes and Ladders
  * The index conversion is the tricky part.
Q752. Open the lock
  * Same thing, the index part is tricky.
  * to push '9' +1 to '0', you can use (x+1)%10 + '0' to get the int value of the char.
Q399 Evaluate Division(try again)
  * Need to be able to convert the question to a graph problem.
Q2101. Detonate the Maximum Bombs
  * Math!
Q127. Word Ladder
  * Time and space complexity.

Binary Tree FAANG Questions:
* https://leetcode.com/discuss/interview-question/6454930/binary-tree-faang-questions
* Red-black tree??