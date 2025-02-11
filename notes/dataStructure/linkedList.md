# Linked List

## Operations
* One should be very familar with reserve single or double linked list.
* Common methods are two pointers. One travel slow one travel fast. In those questions, one should be very familar with difference scenarios and where the pointer should end up at.
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