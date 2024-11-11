package main.java.implementation;

import main.java.implementation.dataStructure.Node;

public class Util {
    public static <T> void swap(T[] arr, int i, int j){
        T helper = arr[i];
        arr[i] = arr[j];
        arr[j] = helper;
    }

    public static void swap(int[] arr, int i, int j){
        int helper = arr[i];
        arr[i] = arr[j];
        arr[j] = helper;
    }

    public static Node createOneDirectionalLinkedList(int length){
        if (length <= 0) {
            return null; // Return null for non-positive length
        }

        Node head = new Node((int)Math.random()*100);  // Create the head node with value 1
        Node current = head;

        for (int i = 2; i <= length; i++) {
            Node newNode = new Node(i);
            current.next = newNode;  // Link current node to new node
            current = newNode;         // Move to the new node
        }
        return head; // Return the head of the linked list
    }

    public static Node createTwoDirectionalLinkedList(int length){
        if (length <= 0) {
            return null; // Return null for non-positive length
        }

        Node head = new Node((int)Math.random()*100);  // Create the head node with value 1
        Node current = head;

        for (int i = 2; i <= length; i++) {
            Node newNode = new Node(i);
            current.next = newNode;  // Link current node to new node
            newNode.prev = current;
            current = newNode;         // Move to the new node
        }
        return head; // Return the head of the linked list
    }
}
