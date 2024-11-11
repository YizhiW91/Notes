package main.java.implementation.sorts;

import main.java.implementation.Util;

public class InsertionSort {

    public static int[] sort(int[] arr){
        if(arr == null || arr.length ==1) return arr;
        for(int i = 1; i<arr.length; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[i]<arr[j]){
                    Util.swap(arr, i--, j);
                }else{
                    break;
                }
            }
        }
        return arr;
    }    
}