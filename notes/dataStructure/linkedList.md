# Linked List

## Advantages and disadvantages compared to arrays
* Pros:
  * add and remove elements at any position in O(1) when you have the reference of the node, otherwise it is O(n) as you need to traverse the whole linked list. For array it is always O(n).
  * Capacity is not fixed. Array has to resize when hitting the max size. Though LL also suffers from additional storage for pointers.
* Cons
  * No random access. O(n) for access an element at nth position. For array it is O(1).

## Type of linked list
* Singly linked list.
* Doubly linked list.
* LL with sentinel nodes.
  * LL with head and tail to make logic cleaner. Head.next is the real head, tail.prev is the real tail.

## Operations
* One should be very familar with the following operations:
  * Traverse
```cpp
function traverse(LinkedListNode* head){
    LinkedListNode *dummy = head;
    while(dummy->next != nullptr){
        cout<< dummy->val << endl;
        dummy = dummy->next;
    }
}
```
  * Insert
```cpp
// single linked list
void insert(LinkedListNode* nodeBefore, LinkedListNode* newNode){
    if (!nodeBefore || !newNode) return; // Avoid null pointer dereference
    newNode->next = nodeBefore->next;
    nodeBefore->next = newNode;
}

// double linked linst
void insert(LinkedListNode* nodeBefore, LinkedListNode* newNode){
    if (!nodeBefore || !newNode) return; // Avoid null pointer dereference
    newNode->next = nodeBefore->next;
    newNode->prev = nodeBefore;
    if (nodeBefore->next) { // Only update prev if nodeBefore is not the last node
        nodeBefore->next->prev = newNode;
    }
    nodeBefore->next = newNode;
}
```
  * Remove
```cpp
// single linked list
void remove(LinkedListNode* nodeBefore){
    if (!nodeBefore || !nodeBefore->next) return; // Check for null to prevent crashes
    nodeBefore->next = nodeBefore->next->next; // Bypass the next node (deleting it)
}

// double linked linst
void remove(LinkedListNode* node){
    if(!node) return;
    if(node->prev) node->prev->next = node->next;
    if(node->next) node->next->prev = node->prev;
}
```

  * reverse single or double linked list.
```cpp
// single linked list
LinkedListNode* reverse(LinkedListNode* head){
    LinkedListNode *curr = head, *prev = nullptr, *tmp;
    while(curr){
        tmp = curr->next;
        curr->next = prev;
        prev = curr;
        curr = tmp;
    }
    return prev;
}

// double linked list
LinkedListNode* reverse(LinkedListNode* head){
    LinkedListNode *curr = head, *prev = nullptr, *tmp;
    while(curr){
        tmp = curr->next;
        // below two line can be done by std::swap(curr->next, curr->prev)
        curr->next = prev;
        curr->prev = tmp;
        prev = curr;
        curr = tmp;
    }
    return prev;
}
```

* Common methods are two pointers, or AKS slow/fast pointers. One travel slow one travel fast. In those questions, one should be very familar with difference scenarios and where the pointer should end up at.
    * Scenario 1. The slow pointer should end up at the middle or middle - 1.
    * Scenario 1. The slow pointer should end up at the middle or middle + 1.

## Challenges
* Dutch Flag Question -  Partition List #86
```java
// solution with space O(N)
public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
        return head;
    ArrayList<ListNode> lessThanX = new ArrayList<>();
    ArrayList<ListNode> greaterOrEqualX = new ArrayList<>();
    while (head != null) {
        if (head.val < x) {
            lessThanX.add(head);
        } else {
            greaterOrEqualX.add(head);
        }
        head = head.next;
    }
    ArrayList<ListNode> allNodes = new ArrayList<>();
    allNodes.addAll(lessThanX);
    allNodes.addAll(greaterOrEqualX);
    for (int i = 0; i < allNodes.size() - 1; i++) {
        allNodes.get(i).next = allNodes.get(i + 1);
    }
    allNodes.get(allNodes.size() - 1).next = null;
    return allNodes.get(0);
}
```

```java
// solution with space O(1)
public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode SB = null, SE = null, LB = null, LE = null;
        while(head != null){
            if(head.val < x){
                if(SB == null){
                    SB = head;
                    SE = head;
                    SB.next = SE;
                } else if (SE == null){
                    SE = head;
                } else {
                    SE.next = head;
                    SE = head;
                }
            } else{
                if(LB == null){
                    LB = head;
                    LB.next = LE;
                } else if (LE == null){
                    LE = head;
                } else {
                    LE.next = head;
                    LE = head;
                }
            }
            head = head.next;
        }
        if(SB == null){
            return LB;
        } else if(LB == null){
            return SB;
        } else {
            SB.next = LB;
            return SB;
        }
    }
```