# Tree
Terminology:
* root
* parent
* child
  * left, right for binary tre
* depth. Root has depth 0.
* complete tree: all levels full, except last. Last level has nodes have 0 or 2 children.


## Binary Trees
A tree with all nodes having a mximum of two children.

Implementation:
C++
```cpp
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};
```

Java
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
        this.val = val;
    }
}
```

### DFS - Depth First Search
There are 3 ways to perform DFS 
* preorder
* inorder
* postorder.

Most of time DFS is implemented using **recursion**, but sometimes **iterative approach with stack** is aslo acceptiable. 

The templates of how to dfs a tree:
```cpp
void dfs(TreeNode* node){
    // step 1. return at the leaf node
    if(node == nullptr){
        return;
    }
    // step 2. run some logic.
    custom_logic();
    // step 3. recursion left
    dfs(node->left);
    // step 4. recursion right
    dfs(node->right);
    return;
} 
```
The sequence of step 2, 3 and 4 determined the type of dfs.
* Preorder: Run the logic on the current node before move on to children. Step 2 over 3 and 4. Left over right. **Pre -> mid before children**
* Inorder: Run the recursion on left first, then current node, then right. Step 3, then 2 and 4. **In -> mid in the middle of children**
* postorder: Run the recursion on left first, followed by right, then current node. Step 3, 4, then 2. **post -> mid after the children**


The implementation of iterative approach
```cpp
void dfs(TreeNode* node){
    stack<TreeNode*> mystack;
    stack.push(node);
    while(!stack.empty()){
        TreeNode* node = stack.pop();
        // do something here.
        someLogic(node);
        // left
        if(node->left != nullptr) stack.push(node->left);
        // right
        if(node->right != nullptr) stack.push(node->right);
    }
    return;
}
```

### BFS - Breath First Search
BFS is implemented iteratively with a queue. 

In binary tree algorithm problems, BFS is usually better than using DFS as it tends to find the solution quicker. In an interview, you may be asked some trivia regarding BFS vs DFS, such as their drawbacks. 
* Efficiency wise, the main disadvantage of DFS is that you could end up wasting a lot of time looking for a value if the value is close to the root but on the right(assuming we go left->right).
* Space wise, DFS uses space linear to the tree depth(O(logN) in a perfect tree), BFS uses space linear to the level size(O(n) in a perfect tree).


The implementation of the iterative approach:
```cpp
void traverse(TreeNode* root){
    queue<TreeNode*> q;
    q.push(root);
    while(!q.empty()){
        // get the size of the level
        int n = q.size();
        for(int i=0; i<n; i++){
            TreeNode* node = q.front();
            q.pop();

            // do some logic here
            cout<<node->val<<endl;

            // add children to the q
            if(node->left) q.push(node->left);
            if(node->right) q.push(node->right);
            
        }
    }
}
```

### Binary search tree




# Graph