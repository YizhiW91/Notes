package implementation;

public class MergeSort{
    // bisect the array, order the sub arrays and merge.
    public static int[] sort(int[] arr){
        if(arr.length == 0) return arr;
        return sortWithIndex(arr, 0, arr.length-1);        
    }  

    public static int[] sortWithIndex(int[] arr, int L, int R){
        if(L == R) return arr;
        int M = (L+R)/2;
        sortWithIndex(arr, L, M);
        sortWithIndex(arr, M+1, R);
        return merge(arr, L, M, R);
    }
        
    // when (L, M) and (M+1, R) are both ordered, merge them together
    private static int[] merge(int[] arr, int L, int M, int R){
        if(L == R) return arr;

        int[] res = new int[R-L+1];
        int i = L;
        int j = M+1;
        int z = 0;
        while(i <= M && j <= R){
            if(arr[i] <= arr[j]){
                res[z] = arr[i];
                i++;
            } else {
                res[z] = arr[j];
                j++; 
            }
            z++;
        }
        while(i<=M){
            res[z] = arr[i];
            i++;
            z++;
        }
        while(j<=R){
            res[z] = arr[j];
            j++;
            z++;
        }
        // assign res back to arr
        for(int k=L; k<=R; k++){
            arr[k] = res[k-L];
        }
        return arr;
    }
}