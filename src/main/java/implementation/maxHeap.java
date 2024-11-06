package main.java.implementation;

/**
 * Offer general operations for managing an int array heap
 */
public class maxHeap {

    // for moving element of index position up
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            Util.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    
    // for moving element of index position up, the first heapSize of the arr is the heap
    public static void heapify(int[] arr, int index, int heapSize){
        // if no left child
        int left = index*2+1;
        while(left < heapSize){
            int larger = left+1< heapSize && (arr[left+1]> arr[left]) ? left+1 : left;
            if(arr[index] < arr[larger]){
                Util.swap(arr, index, larger);
                index = larger;
                left = index*2+1;
            } else {
                break;
            }
        }
    }
}