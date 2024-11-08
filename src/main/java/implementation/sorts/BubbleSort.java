package main.java.implementation.sorts;

import main.java.implementation.Util;
import main.java.implementation.maxHeap;

public class BubbleSort {

    public static int[] sort(int[] arr){
        if(arr == null) return arr;
        int count = arr.length-1;
        while(count>0){
            boolean swap = false;
            for(int i=0; i<count; i++){
                if(arr[i]>arr[i+1]){
                    Util.swap(arr, i, i+1);
                    swap = true;
                }  
            }
            if(!swap) break;
            count--;
        }
        return arr;
    }    
}