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
If the left child value always less than the parent value, and the parent value is less than the right child value. The tree is 
called binary search tree.

#### Operations in O(logN) time.
* Searching - Binary search
* Adding
  * one could always insert a new node as a child of the leaf without breaking existing BST.
    * Start at the root.
    * Compare the new value to the current node
    * Recursively go left or right depending on comparison:
        * If new value < current node → go left.
        * If new value ≥ current node → go right.
    * When you reach a nullptr (empty child), you insert the new value there as a leaf.
* Removing

#### Traverse.
Traversing the tree from min to max can be done via inorder DFS.
```cpp
void dfs(TreeNode* root){
    // traverse left
    dfs(root->left);
    // mid
    some_oepration(root);
    // traverse right
    dfs(root->right);
}
```

It is also possible to use iterative approach, but inorder dfs iteration is more complicated than preorder dfs.
```cpp
void inorder_iter_dfs(TreeNode* root){
    stack<TreeNode*> s;
    TreeNode* curr = root;
    while(!s.empty() || curr != nullptr){
        if(curr != nullptr){
            s.push(curr);
            curr = curr->left;
        }else{
            curr = s.top();
            s.pop();
            // do operation for node here
            do_something(curr);
            curr = curr->right;
        }
    }
}
```

### Binary search tree - Red-Black Tree
In a regular BST, performance can degrade to O(n) if the tree becomes unbalanced (like a linked list). A Red-Black Tree ensures that the tree height stays logarithmic in the number of nodes — so operations like search, insert, and delete stay O(log n).

Each node has a color: red or black. The tree maintains these 5 rules:
* Every node is either red or black.
* The root is always black.
* All leaves (null pointers) are considered black.
* Red nodes can’t have red children (i.e., no two reds in a row).
* Every path from a node to its descendant nulls has the same number of black nodes (called "black-height").


⚙️ Operations (Search / Insert / Delete)
* Search works just like in a normal BST.
* Insert: Node is initially added as red, then the tree is adjusted (recoloring + rotation) to fix violations.
* Delete: More complex; removal may cause imbalance and requires fixes (may involve multiple rotations and recoloring).


# Graph

Concepts:
* Edges of a node can either be **directed** or **undirected**. 
* Connected component: A group of nodes that are connected by edges.
*  The number of edges that can be used to reach the node is the node's **indegree**. 
*  The number of edges that can be used to leave the node is the node's **outdegree**. 
*  Nodes that are connected by an edge are called **neighbors**. 
*  A graph can be either **cyclic** or **acyclic**. 
   *  Cyclic means that the graph has a cycle.
   *  Acyclic means that it doesn't. 

## Common Interview Questions
In graph problems, there are multiple common formats that graph will be given in.
* Array of edges
  * In this input format, the input will be a 2D array. Each element of the array will be in the form [x, y], which indicates that there is an edge between x and y.
  * It is slow to iterate through the array for every node to find out the neighbors. Instead, we use pre-process the array and put start ->end to a **hashmap**. This is **VERY COMMON**.
* Adjacency list
  * In an adjacency list, the nodes will be numbered from 0 to n - 1. The input will be a 2D integer array, let's call it graph. graph[i] will be a list of all the outgoing edges from the ith node. This is the best format, equvalent to the hashmap, usually it does not need conversion.
* Adjacency matrix
  * The nodes will be numbered from 0 to n - 1. You will be given a 2D matrix of size n x n, let's call it graph. If graph[i][j] == 1, that means there is an outgoing edge from node i to node j.
  * We can preproess the matrix to create a **hashmap** to aovid going through the matrix everytime when we need to access neighbor of ith node. Though both approaches are O(n2).
* Matrix
  * Each element in the matrix represents a node. The edge is usually determined by direct adjacency. Those problems need careful understanding on the question description.


## DFS
When using DFS on graph questions, it helps to maintain a seen set or array to track which node was visited to avoid cycle/undirected graph questions.

It is also very common to use a boolean array `seen` to track which node has been visited. In DFS, especially in recursion, **make sure that the node is marked as seen** before go into the recursion function.
```cpp
// some for loop
for(auto v: map[curr]){
    if(!seen[v]){
        seen[v] = true; //VERY IMPORTANT
        dfs(v);
    }
}
```

Mark the element as seen before entering the recursion ganrantees that same node won't be accessed multiple times causing duplicated count.

Example:
Here is the graph[[0,1], [0,2], [1,2]]. If we start with 0, the dfs steps are:
* 0 connects to 1 and 2, add both to the stack. stack: [2,1];
* pop stack top, 1 is popped.
* 1 connects to 2. If we don't mark 2 as seen before adding it to the stack, **2 will be again added to the stack**, ending up with [2,2]. The algo basically processes node #2 twice.


## BFS
In many graph problems, it doesn't really matter if you use DFS or BFS. But, there are some problems where using BFS is clearly better than using DFS. In trees, this was the case when we were concerned with tree levels. In graphs, it is mostly the case when you are asked to find the **shortest path**.

BFS on a graph always visits nodes according to their distance from the starting point. This is the key idea behind BFS on graphs - every time you visit a node, you must have reached it in the minimum steps possible from wherever you started your BFS.