package main.java.implementation.dataStructure;

/**
 * Offer general operations for managing an int array heap
 */
public class LinkedList {

    public static Node reverseOneDirectionLinkedList(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    
}