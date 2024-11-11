package main.java.implementation.sorts;

import main.java.implementation.Util;
import main.java.implementation.dataStructure.MaxHeap;

public class HeapSort {

    public static int[] sort(int[] arr){
        int heapSize = arr.length;
        // first, make the array max heap
        for(int i = (arr.length/2)-1; i>=0; i--){
            MaxHeap.heapify(arr, i, heapSize);
        }
        // then pop the root, swap it with the end of the array, lower the heapSize
        while(heapSize > 0){
            Util.swap(arr, 0, (heapSize-1));
            MaxHeap.heapify(arr, 0, --heapSize);
        }
        return arr;
    }    
}