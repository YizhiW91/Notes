package main.java.implementation.sorts;

public class MergeSort{
    // bisect the array, order the sub arrays and merge.
    public static int[] sort(int[] arr){
        if(arr.length == 0) return arr;
        sortWithIndex(arr, 0, arr.length-1); 
        return arr;     
    }  

    public static void sortWithIndex(int[] arr, int L, int R){
        if(L == R) return ;
        int M = L + ((R - L)>>1);
        sortWithIndex(arr, L, M);
        sortWithIndex(arr, M+1, R);
        merge(arr, L, M, R);
    }
        
    // when (L, M) and (M+1, R) are both ordered, merge them together
    private static void merge(int[] arr, int L, int M, int R){
        int[] res = new int[R-L+1];
        int i = L;
        int j = M+1;
        int z = 0;
        while(i <= M && j <= R){
            res[z++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while(i<=M){
            res[z++] = arr[i++];
        }
        while(j<=R){
            res[z++] = arr[j++];
        }
        // assign res back to arr
        for(int k=L; k<=R; k++){
            arr[k] = res[k-L];
        }
    }
}