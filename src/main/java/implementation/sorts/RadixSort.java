package main.java.implementation.sorts;

import java.util.ArrayList;
import java.util.HashMap;


public class RadixSort{
    public static int[] sort(int[] arr){
        if(arr == null) return arr;
        radixSort(arr, 0, arr.length-1);
        return arr;
    }  

    /*
     * Basic bucket sort implementation. Sort the arr from index l to r in place
     */
    public static void bucketSort(int[] arr, int l, int r){
        int maxValue = getMax(arr, l, r);
        int maxDigit = getMaxDigit(maxValue);
        HashMap<Integer, ArrayList<Integer>> buckets = new HashMap<>();
        // start loop
        for(int d=1; d<=maxDigit ; d++){
            for(int index = 0; index<10; index++){
                buckets.put(index, new ArrayList<>());
            }
            // loop over arr
            for(int index = l; index<= r; index++){
                int numInDigit = getDigit(arr[index], d);
                buckets.get(numInDigit).add(arr[index]);
            }
            // pour out
            int start = l;
            for(int key = 0; key<10; key++){
                for(int n: buckets.get(key)){
                    arr[start++] = n;
                }
            }
            // Clear buckets for the new digit pass
            for (int key = 0; key < 10; key++) {
                buckets.get(key).clear();
            }
        }
    }

    /*
     * Advanced radix sort implementation. Sort the arr from index l to r in place
     */
    public static void radixSort(int[] arr, int l, int r){
        int maxValue = getMax(arr, l, r);
        int maxDigit = getMaxDigit(maxValue);
        for(int d = 1; d<=maxDigit; d++){
            int[] counter = new int[10];
            // put numbers into counter
            for(int i = l; i<= r; i++){
                int numInDigit = getDigit(arr[i], d);
                counter[numInDigit]++;
            }
            // convert counter into a less than or equal to count array by accumulative sum from the beginning
            // for example, the counter is [0,1,2,1,0,0,0,0,0,0]
            // after the change, value goes[0,1,3,4,4,4,4,4,4,4], meaning how many numbers have numbers in this digit less than or equal to the position index
            for(int i = 1; i<10; i++){
                counter[i] += counter[i-1];
            }
            // pour the array(i, j) from the end to start and put them into the helper array
            int[] helper = new int[r-l+1];
            for(int i = r; i>=l; i--){
                int numInDigit = getDigit(arr[i], d);
                int pos = counter[numInDigit] - 1;
                helper[pos] = arr[i];
                counter[numInDigit]--;
            }
            // assign helper back
            for(int i=l; i<=r; i++){
                arr[i] = helper[i-l];
            }
        }
    }

    /* 
     * Get max digit from the given n. Exp, 2 will be return if the given number is 10
     */
    public static int getMaxDigit(int n){
        int d = 0;
        while(n != 0){
            d++;
            n /= 10;
        }
        return d;
    }

    public static int getDigit(int n, int digit){
        for(int i = 1; i < digit; i++ ){
            n /=10;
        }
        return n%10;
    }

    public static int getMax(int[] arr, int l, int r){
        int max = arr[l];
        for(int i = l; i<=r; i++){
            max = arr[i]>max ? arr[i] : max;
        }
        return max;
    }

}