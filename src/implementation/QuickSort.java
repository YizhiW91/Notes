package implementation;

public class QuickSort{
    public static int[] sort(int[] arr){
        if(arr == null || arr.length == 0) return arr;
        quickSort3(arr, 0, arr.length-1);
        return arr;
    }  

    public static int partitionWithLast(int[] arr, int L, int R){
        // using the last number in the [L, R] range as the target
        int k = arr[R];
        int i = L;
        int less = i-1;
        while(i<=R){
            // when current number at i <= target, swap it with the next number of the less zone, and increase less zone.
            if(arr[i]<=k){
                swap(arr, i, less+1);
                less++;
            }
            i++;
        }
        return less;
    }

    // version 1 quick sort, select the last position number to sort
    public static void quickSort1(int[] arr, int L, int R){
        if(L >= R) return;
        int k = partitionWithLast(arr, L, R);
        quickSort1(arr, L, k-1);
        quickSort1(arr, k+1, R);
    }

    public static int partitionWithRandom(int[] arr, int L, int R){
        // using the last number in the [L, R] range as the target
        int k = arr[(int)(Math.random()*(R-L+1)) + L];
        int i = L;
        int less = i-1;
        while(i<=R){
            // when current number at i <= target, swap it with the next number of the less zone, and increase less zone.
            if(arr[i]<=k){
                swap(arr, i, less+1);
                less++;
            }
            i++;
        }
        return less;
    }

    // version 2 quick sort, select the random position number to sort
    public static void quickSort2(int[] arr, int L, int R){
        if(L >= R) return;
        int k = partitionWithRandom(arr, L, R);
        quickSort2(arr, L, k-1);
        quickSort2(arr, k+1, R);
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
                swap(arr, i++, ++less);
            } else if (arr[i] == k){
            // when current number at i == target, i++, no need to move less or more zone
                i++;
            } else {
            // when current number at i > target, swap with the previous number of the more zone, increase more zone, do not move i as number on the i has not been reviewed
                swap(arr, i, --more);
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

    // swap i and j value
    public static void swap(int[] arr, int i, int j){
        int helper = arr[i];
        arr[i] = arr[j];
        arr[j] = helper;
    }
    
}