package main.java.implementation.sorts;

import java.rmi.server.UID;

import main.java.implementation.Util;

public class QuickSort{
    public static int[] sort(int[] arr){
        if(arr == null || arr.length == 0) return arr;
        quickSort2(arr, 0, arr.length-1);
        return arr;
    }  

    public static int partitionWithLast(int[] arr, int L, int R){
        // using the last number in the [L, R] range as the target
        int pivot = arr[R];
        int less = L-1;
        for(int i=L; i<R; i++){
            // when current number at i <= target, swap it with the next number of the less zone, and increase less zone.
            if(arr[i]<=pivot){
               Util.swap(arr, i, less+1);
                less++;
            }
        }
        Util.swap(arr, less+1, R);
        return less+1;
    }

    // version 1 quick sort, select the last position number to sort
    public static void quickSort1(int[] arr, int L, int R){
        if(L >= R) return;
        int pivot = partitionWithLast(arr, L, R);
        quickSort1(arr, L, pivot-1);
        quickSort1(arr, pivot+1, R);
    }

    public static int partitionWithRandom(int[] arr, int L, int R){
        // using the last number in the [L, R] range as the target
        int pivot = (int)(Math.random()*(R-L+1)) + L;
        Util.swap(arr, R, pivot);
        int less = L-1;
        for(int i = L; i<R; i++){
            // when current number at i <= target, swap it with the next number of the less zone, and increase less zone.
            if(arr[i]<=arr[R]){
               Util.swap(arr, i, less+1);
                less++;
            }
        }
        Util.swap(arr, less+1, R);
        return less+1;
    }

    // version 2 quick sort, select the random position number to sort
    public static void quickSort2(int[] arr, int L, int R){
        if(L >= R) return;
        int pivot = partitionWithRandom(arr, L, R);
        quickSort2(arr, L, pivot-1);
        quickSort2(arr, pivot+1, R);
    }

    public static int[] partitionIntoThree(int[] arr, int L, int R){
        // using the last number in the [L, R] range as the target
        int k = arr[(int)(Math.random()*(R-L+1)) + L];
        int i = L;
        int less = i-1; // less zone
        int more = R+1; // more zone
        while(i < more){
            // when current number at i < target, swap it with the next number of the less zone, and increase less zone,
            if(arr[i]<k){
                Util.swap(arr, i++, ++less);
            } else if (arr[i] == k){
            // when current number at i == target, i++, no need to move less or more zone
                i++;
            } else {
            // when current number at i > target, swap with the previous number of the more zone, increase more zone, do not move i as number on the i has not been reviewed
                Util.swap(arr, i, --more);
            }
        }
        return new int[] {less, more};
    }

    // version 3 quick sort, select the random position number to sort, put the equal numbers in the middle, only sort the small and large portion.
    public static void quickSort3(int[] arr, int L, int R){
        if(L >= R) return;
        int[] lessMore = partitionIntoThree(arr, L, R);
        quickSort2(arr, L, lessMore[0]);
        quickSort2(arr, lessMore[1], R);
    }
}